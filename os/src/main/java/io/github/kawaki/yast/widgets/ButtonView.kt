package io.github.kawaki.yast.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
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

    private var binding = ViewButtonBinding.inflate(LayoutInflater.from(context), this, true)
    private var text: String? = null
    private var style: ButtonViewStyles? = null

    init {
        context.withStyledAttributes(attrs, R.styleable.ButtonView) {
            style = ButtonViewStyles.fromParams(
                getInt(
                    R.styleable.ButtonView_button_view_style,
                    ButtonViewStyles.ROUNDED.style
                )
            )
            text = getString(R.styleable.ButtonView_button_view_text)
        }
        setUpView()
    }

    private fun setUpView() {
        setUpStyle()
        setUpText()
    }

    private fun setUpStyle() {
        when (style) {
            ButtonViewStyles.ROUNDED_TOP_CORNERS -> {
                binding.root.setBackgroundResource(R.drawable.background_view_button_top)
            }
            ButtonViewStyles.ROUNDED -> {
                binding.root.setBackgroundResource(R.drawable.background_view_button_mid)
            }
            ButtonViewStyles.ROUNDED_BOTTOM_CORNERS -> {
                binding.root.setBackgroundResource(R.drawable.background_view_button_bot)
            }
            else -> {
                binding.root.setBackgroundResource(R.drawable.background_view_button_mid)
            }
        }
    }

    private fun setUpText() {
        if (text != null) binding.buttonText.text = text
    }

}