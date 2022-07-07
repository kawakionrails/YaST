package io.github.kawaki.yast.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.R
import io.github.kawaki.yast.databinding.ActivityMainBinding
import io.github.kawaki.yast.ui.base.BaseActivity
import io.github.kawaki.yast.utils.FullscreenMode

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val viewModel by viewModels<MainViewModel>()
    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                Intent.ACTION_TIME_TICK -> {
                    setUpClock()
                }
                else -> {
                    // TODO: Not yet implemented
                }
            }
        }
    }
    private val intentFilter: IntentFilter = IntentFilter()
    private val navHostFragment: NavHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment }
    private val navController: NavController by lazy { navHostFragment.navController }
    private val onDestinationChangedListener: NavController.OnDestinationChangedListener =
        NavController.OnDestinationChangedListener { _, _, _ ->
            setUpShell()
        }

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpActivity()
    }

    private fun setUpActivity() {
        setUpBroadcastReceiver()
        setUpShell()
        setUpClock()
        setUpObservables()
        viewModel.setFullscreenMode(window, binding.root, FullscreenMode.TRUE)
    }

    private fun setUpBroadcastReceiver() {
        intentFilter.addAction(Intent.ACTION_TIME_TICK)
        registerReceiver(broadcastReceiver, intentFilter)
    }

    private fun setUpShell() {
        viewModel.getFragmentsWithoutShell.forEach {
            if (navController.currentDestination?.id != it) {
                binding.shell.visibility = View.VISIBLE
            } else {
                binding.shell.visibility = View.GONE
            }
        }
        viewModel.getFragmentsWithShellTransparency.forEach {
            if (navController.currentDestination?.id != it) {
                binding.shell.setBackgroundColor(getColor(R.color.light_mode_background))
            } else {
                binding.shell.setBackgroundColor(getColor(R.color.transparent))
            }
        }
        viewModel.getFragmentsWithWhiteClock.forEach {
            if (navController.currentDestination?.id == it) {
                binding.clock.setTextColor(getColor(R.color.white))
            } else {
                binding.clock.setTextColor(getColor(R.color.black))
            }
        }
    }

    private fun setUpClock() {
        binding.clock.text = viewModel.getClockValue()
    }

    private fun setUpObservables() {
        navController.addOnDestinationChangedListener(onDestinationChangedListener)
    }

}