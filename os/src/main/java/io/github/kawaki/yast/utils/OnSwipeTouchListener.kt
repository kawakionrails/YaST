package io.github.kawaki.yast.utils

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

open class OnSwipeTouchListener(context: Context) : View.OnTouchListener {

    companion object {
        private const val DEF_SWIPE_THRESHOLD: Int = 100
        private const val DEF_SWIPE_THRESHOLD_SPEED: Int = 100
    }

    private var gestureDetector: GestureDetector? = null

    init {
        gestureDetector = GestureDetector(context, GestureListener())
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(motionEvent: MotionEvent?): Boolean {
            return true
        }

        override fun onFling(
            motionEvent1: MotionEvent,
            motionEvent2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            var result = false
            try {
                val motionEventX = motionEvent2.x - motionEvent1.x
                val motionEventY = motionEvent2.y - motionEvent1.y
                if (abs(motionEventX) > abs(motionEventY)) {
                    if (abs(motionEventX) > DEF_SWIPE_THRESHOLD && abs(velocityX) > DEF_SWIPE_THRESHOLD_SPEED) {
                        if (motionEventX < 0) {
                            onSwipeLeft()
                        } else {
                            onSwipeRight()
                        }
                        result = true
                    }
                } else if (abs(motionEventY) > DEF_SWIPE_THRESHOLD && abs(velocityY) > DEF_SWIPE_THRESHOLD_SPEED) {
                    if (motionEventY < 0) {
                        onSwipeTop()
                    } else {
                        onSwipeBottom()
                    }
                    result = true
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
            return result
        }
    }

    override fun onTouch(view: View?, motionEvent: MotionEvent?): Boolean {
        return gestureDetector?.onTouchEvent(motionEvent) ?: false
    }

    open fun onSwipeTop() {
        // TODO: Not yet implemented
    }

    open fun onSwipeBottom() {
        // TODO: Not yet implemented
    }

    open fun onSwipeLeft() {
        // TODO: Not yet implemented
    }

    open fun onSwipeRight() {
        // TODO: Not yet implemented
    }

}