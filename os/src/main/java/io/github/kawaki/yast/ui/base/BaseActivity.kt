package io.github.kawaki.yast.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import io.github.kawaki.yast.utils.Constants

abstract class BaseActivity<VIEW_BINDING : ViewBinding>(
    private val inflater: (
        layoutInflater: LayoutInflater,
    ) -> VIEW_BINDING,
) : AppCompatActivity() {

    private var _binding: VIEW_BINDING? = null
    val binding: VIEW_BINDING get() = _binding as VIEW_BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflater.invoke(layoutInflater)
        if (_binding != null) {
            setContentView(binding.root)
        } else {
            throw IllegalArgumentException(Constants.BINDING_CANNOT_BE_NULL)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun getViewBinding(): VIEW_BINDING

}