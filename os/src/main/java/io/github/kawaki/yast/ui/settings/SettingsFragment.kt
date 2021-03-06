package io.github.kawaki.yast.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.R
import io.github.kawaki.yast.databinding.FragmentSettingsBinding
import io.github.kawaki.yast.ui.base.BaseFragment
import io.github.kawaki.yast.utils.OnSwipeTouchListener

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    private val viewModel by viewModels<SettingsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpFragment()
    }

    private fun setUpFragment() {
        setUpObservables()
    }

    private fun setUpObservables() {
        binding.root.setOnTouchListener(object : OnSwipeTouchListener(requireContext()) {
            override fun onSwipeRight() {
                super.onSwipeRight()
                findNavController().popBackStack()
            }
        })
        binding.general.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_generalFragment)
        }
    }

}