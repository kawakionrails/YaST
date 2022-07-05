package io.github.kawaki.yast.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import io.github.kawaki.yast.utils.Constants

abstract class BaseFragment<VIEW_BINDING : ViewBinding>(
    private val layoutInflater: (inflater: LayoutInflater) -> VIEW_BINDING
) : Fragment() {

    private var _binding: VIEW_BINDING? = null
    val binding: VIEW_BINDING get() = _binding as VIEW_BINDING

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = layoutInflater.invoke(inflater)
        if (_binding != null) {
            return binding.root
        } else {
            throw IllegalArgumentException(Constants.BINDING_CANNOT_BE_NULL)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}