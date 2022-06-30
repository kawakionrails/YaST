package io.github.kawaki.yast.extensions

import android.view.View
import androidx.constraintlayout.widget.Group

fun Group.setAllOnClickListener(onClickListener: View.OnClickListener) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id).setOnClickListener(onClickListener)
    }
}