package io.github.kawaki.yast.ui

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.databinding.ActivityMainBinding
import io.github.kawaki.yast.enum.FullscreenMode
import io.github.kawaki.yast.ui.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val viewModel by viewModels<MainViewModel>()

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpActivity()
    }

    private fun setUpActivity() {
        setUpScreen()
    }

    private fun setUpScreen() {
        viewModel.setFullscreenMode(window, binding.root, FullscreenMode.TRUE)
    }

}