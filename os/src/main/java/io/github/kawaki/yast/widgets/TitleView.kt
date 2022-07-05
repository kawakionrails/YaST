package io.github.kawaki.yast.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.R
import io.github.kawaki.yast.databinding.ViewTitleBinding

@AndroidEntryPoint
class TitleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding = ViewTitleBinding.inflate(LayoutInflater.from(context), this, true)
    private var previousScreen: String? = null
    private var currentScreen: String? = null

    init {
        context.withStyledAttributes(attrs, R.styleable.TitleView) {
            previousScreen =
                getString(R.styleable.TitleView_title_view_previous_screen)
            currentScreen =
                getString(R.styleable.TitleView_title_view_current_screen)
        }
        setUpView()
    }

    private fun setUpView() {
        setUpPreviousScreen()
        setUpCurrentScreen()
    }

    private fun setUpPreviousScreen() {
        if (previousScreen != null) {
            binding.titleBackwardLayout.visibility = View.VISIBLE
            binding.titlePreviousScreen.text = previousScreen
        } else {
            binding.titleBackwardLayout.visibility = View.GONE
        }
    }

    private fun setUpCurrentScreen() {
        if (currentScreen != null) {
            binding.titleCurrentScreen.text = currentScreen
        }
    }

}