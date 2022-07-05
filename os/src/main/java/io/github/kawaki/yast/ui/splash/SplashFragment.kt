package io.github.kawaki.yast.ui.splash

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.R
import io.github.kawaki.yast.databinding.FragmentSplashBinding
import io.github.kawaki.yast.ui.MainActivity
import io.github.kawaki.yast.ui.base.BaseFragment

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    companion object {
        private const val DEF_HOME_FRAGMENT_DELAY_MILLIS: Long = 3000
    }

    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpFragment()
    }

    private fun setUpFragment() {
        viewModel.goToHomeFragment(
            findNavController(),
            R.id.action_splashFragment_to_homeFragment,
            DEF_HOME_FRAGMENT_DELAY_MILLIS
        )
    }

}