package io.github.kawaki.yast.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.R
import io.github.kawaki.yast.databinding.ViewButtonBinding

@AndroidEntryPoint
class ButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding = ViewButtonBinding.inflate(LayoutInflater.from(context), this, true)
    private var text: String? = null

    init {
        context.withStyledAttributes(attrs, R.styleable.ButtonView) {
            text = getString(R.styleable.ButtonView_button_view_text)
        }
        setUpView()
    }

    private fun setUpView() {
        setUpText()
    }

    private fun setUpText() {
        if (text != null) binding.buttonText.text = text
    }

}