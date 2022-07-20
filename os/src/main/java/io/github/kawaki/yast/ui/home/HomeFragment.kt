package io.github.kawaki.yast.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.R
import io.github.kawaki.yast.databinding.FragmentHomeBinding
import io.github.kawaki.yast.ui.base.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpFragment()
    }

    private fun setUpFragment() {
        setUpObservables()
    }

    private fun setUpObservables() {
        binding.settings.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_nav_settings)
        }
    }

}