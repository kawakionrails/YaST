package io.github.kawaki.yast.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.databinding.ActivityMainBinding
import io.github.kawaki.yast.enum.FullscreenMode
import io.github.kawaki.yast.enum.ShellVisibility
import io.github.kawaki.yast.ui.base.BaseActivity
import java.text.SimpleDateFormat
import java.util.*

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

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpActivity()
    }

    private fun setUpActivity() {
        setUpScreen()
        setUpBroadcastReceiver()
    }

    private fun setUpScreen() {
        setUpClock()
        viewModel.setFullscreenMode(window, binding.root, FullscreenMode.TRUE)
    }

    private fun setUpBroadcastReceiver() {
        registerReceiver(broadcastReceiver, intentFilter)
    }

    private fun setUpClock() {
        val simpleDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val formattedDate = simpleDateFormat.format(Date())
        binding.clock.text = formattedDate
    }

    fun setShellVisibility(visibility: ShellVisibility) {
        when (visibility) {
            ShellVisibility.VISIBLE -> {
                binding.shell.visibility = View.VISIBLE
            }
            ShellVisibility.INVISIBLE -> {
                binding.shell.visibility = View.INVISIBLE
            }
            ShellVisibility.GONE -> {
                binding.shell.visibility = View.GONE
            }
        }
    }

}