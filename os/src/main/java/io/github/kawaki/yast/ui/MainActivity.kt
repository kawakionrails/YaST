package io.github.kawaki.yast.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.databinding.ActivityMainBinding
import io.github.kawaki.yast.enum.FullscreenMode

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpActivity()
    }

    private fun setUpActivity() {
        setUpScreen()
    }

    private fun setUpScreen() {
        viewModel.setFullscreenMode(window, binding.root, FullscreenMode.TRUE)
    }

}