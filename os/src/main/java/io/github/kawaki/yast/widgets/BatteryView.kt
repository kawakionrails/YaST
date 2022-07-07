package io.github.kawaki.yast.widgets

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BatteryView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        setUpView()
    }

    private fun setUpView() {
        // TODO: Not yet implemented
    }

}