package io.github.kawaki.yast.widgets

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
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
        private const val DEF_APP_ICON_BACKGROUND: Int = R.color.black
    }

    private var binding = ViewAppBinding.inflate(LayoutInflater.from(context), this, true)
    private var appIconImage: Drawable? = null
    private var appIconBackground: Int? = null
    private var appName: String? = null

    init {
        context.withStyledAttributes(attrs, R.styleable.AppView) {
            appIconImage =
                getDrawable(R.styleable.AppView_app_view_app_icon_image)
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
        setUpAppIconBackground()
        setUpAppName()
    }

    private fun setUpAppIconImage() {
        if (appIconImage != null) binding.appIconImage.setImageDrawable(appIconImage)
    }

    private fun setUpAppIconBackground() {
        if (appIconBackground != null) binding.appIcon.setBackgroundColor(
            context.getColor(appIconBackground ?: DEF_APP_ICON_BACKGROUND)
        )
    }

    private fun setUpAppName() {
        if (appName != null) binding.appName.text = appName
    }

}