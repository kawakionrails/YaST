package io.github.kawaki.yast.extensions

import android.view.View
import androidx.constraintlayout.widget.Group
import io.github.kawaki.yast.utils.OnSwipeTouchListener

fun Group.setAllOnClickListener(onClickListener: View.OnClickListener) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id).setOnClickListener(onClickListener)
    }
}

fun Group.setAllOnSwipeTouchListener(onSwipeTouchListener: OnSwipeTouchListener) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id).setOnTouchListener(onSwipeTouchListener)
    }
}