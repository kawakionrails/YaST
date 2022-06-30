package io.github.kawaki.yast.ui.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.databinding.FragmentHomeBinding
import io.github.kawaki.yast.enum.ShellVisibility
import io.github.kawaki.yast.ui.MainActivity
import io.github.kawaki.yast.ui.base.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpFragment()
    }

    private fun setUpFragment() {
        setUpScreen()
    }

    private fun setUpScreen() {
        (activity as MainActivity).setShellVisibility(ShellVisibility.VISIBLE)
    }

}