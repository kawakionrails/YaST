package io.github.kawaki.yast.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import io.github.kawaki.yast.databinding.ActivityMainBinding
import io.github.kawaki.yast.utils.Constants
import java.lang.IllegalArgumentException

abstract class BaseActivity<VIEW_BINDING : ViewBinding>(
    private val layoutInflater: (
        layoutInflater: LayoutInflater
    ) -> VIEW_BINDING
) : AppCompatActivity() {

    private var _binding: VIEW_BINDING? = null
    val binding: VIEW_BINDING get() = _binding as VIEW_BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (_binding != null) {
            _binding = getViewBinding()
        } else {
            throw IllegalArgumentException(Constants.BINDING_CANNOT_BE_NULL)
        }
    }

    protected abstract fun getViewBinding(): VIEW_BINDING

}