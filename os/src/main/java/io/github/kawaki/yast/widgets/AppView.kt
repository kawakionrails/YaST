package io.github.kawaki.yast.widgets

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import dagger.hilt.android.AndroidEntryPoint
import io.github.kawaki.yast.R
import io.github.kawaki.yast.databinding.ViewAppBinding

@AndroidEntryPoint
class AppView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val DEF_APP_ICON_IMAGE_COLOR: Int = R.color.black
        private const val DEF_APP_ICON_BACKGROUND: Int = R.color.black
    }

    private var binding = ViewAppBinding.inflate(LayoutInflater.from(context), this, true)
    private var appIconImage: Drawable? = null
    private var appIconImageColor: Int? = null
    private var appIconBackground: Int? = null
    private var appName: String? = null

    init {
        context.withStyledAttributes(attrs, R.styleable.AppView) {
            appIconImage =
                getDrawable(R.styleable.AppView_app_view_app_icon_image)
            appIconImageColor =
                getColor(
                    R.styleable.AppView_app_view_app_icon_image_color, context.getColor(
                        DEF_APP_ICON_IMAGE_COLOR
                    )
                )
            appIconBackground =
                getColor(
                    R.styleable.AppView_app_view_app_icon_background,
                    context.getColor(DEF_APP_ICON_BACKGROUND)
                )
            appName =
                getString(R.styleable.AppView_app_view_app_name)
        }
        setUpView()
    }

    private fun setUpView() {
        setUpAppIconImage()
        setUpAppIconImageColor()
        setUpAppIconBackground()
        setUpAppName()
    }

    private fun setUpAppIconImage() {
        if (appIconImage != null) binding.appIconImage.setImageDrawable(appIconImage)
    }

    private fun setUpAppIconImageColor() {
        if (appIconImageColor != null) binding.appIconImage.setColorFilter(
            appIconImageColor ?: DEF_APP_ICON_IMAGE_COLOR
        )
    }

    private fun setUpAppIconBackground() {
        if (appIconBackground != null) binding.appIconBackground.setCardBackgroundColor(
            appIconBackground ?: DEF_APP_ICON_BACKGROUND
        )
    }

    private fun setUpAppName() {
        if (appName != null) {
            binding.appName.visibility = View.VISIBLE
            binding.appName.text = appName
        }
    }

}