package io.github.kawaki.yast.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.R
import io.github.kawaki.yast.databinding.ViewButtonBinding
import io.github.kawaki.yast.utils.ButtonViewStyles

@AndroidEntryPoint
class ButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val DEF_CALLBACK: Boolean = false
    }

    private var binding = ViewButtonBinding.inflate(LayoutInflater.from(context), this, true)
    private var text: String? = null
    private var callback: Boolean? = null
    private var callbackText: String? = null
    private var forward: Boolean? = null
    private var style: ButtonViewStyles? = null

    init {
        context.withStyledAttributes(attrs, R.styleable.ButtonView) {
            text =
                getString(R.styleable.ButtonView_button_view_text)
            callback =
                getBoolean(R.styleable.ButtonView_button_view_callback, DEF_CALLBACK)
            callbackText =
                getString(R.styleable.ButtonView_button_view_callback_text)
            style =
                ButtonViewStyles.fromParams(
                    getInt(
                        R.styleable.ButtonView_button_view_style,
                        ButtonViewStyles.ROUNDED.style
                    )
                )
        }
        setUpView()
    }

    private fun setUpView() {
        setUpText()
        setUpCallback()
        setUpCallbackText()
        setUpForward()
        setUpStyle()
    }

    private fun setUpText() {
        if (text != null) binding.buttonText.text = text
    }

    private fun setUpCallback() {
        when (callback) {
            true -> binding.buttonCallback.visibility = View.VISIBLE
            false -> binding.buttonCallback.visibility = View.GONE
            else -> binding.buttonCallback.visibility = View.GONE
        }
    }

    private fun setUpCallbackText() {
        if (callback == true) {
            if (callbackText != null) {
                if (forward == false) {
                    binding.buttonCallback.text = callbackText
                } else {
                    binding.buttonCallback.setPadding(0, 0, 16, 0)
                    binding.buttonCallback.text = callbackText
                }
            }
        }
    }

    private fun setUpForward() {
        when (forward) {
            true -> binding.buttonForward.visibility = View.VISIBLE
            false -> binding.buttonForward.visibility = View.GONE
            else -> binding.buttonForward.visibility = View.GONE
        }
    }

    private fun setUpStyle() {
        when (style) {
            ButtonViewStyles.ROUNDED_TOP_CORNERS -> binding.root.setBackgroundResource(R.drawable.background_view_button_top_corners)
            ButtonViewStyles.ROUNDED -> binding.root.setBackgroundResource(R.drawable.background_view_button_rounded)
            ButtonViewStyles.ROUNDED_BOTTOM_CORNERS -> binding.root.setBackgroundResource(R.drawable.background_view_button_bottom_corners)
            else -> binding.root.setBackgroundResource(R.drawable.background_view_button_rounded)
        }
    }

}