package io.github.kawaki.yast.ui

import android.view.View
import android.view.Window
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.kawaki.yast.R
import io.github.kawaki.yast.utils.FullscreenMode
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    val getFragmentsWithShell: MutableList<Int> = mutableListOf(
        R.id.homeFragment,
        R.id.settingsFragment
    )

    fun setFullscreenMode(window: Window, view: View, fullscreenMode: FullscreenMode) {
        when (fullscreenMode) {
            FullscreenMode.TRUE -> {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                WindowInsetsControllerCompat(window, view).let {
                    it.hide(WindowInsetsCompat.Type.systemBars())
                    it.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
                }
            }
            FullscreenMode.FALSE -> {
                WindowCompat.setDecorFitsSystemWindows(window, true)
                WindowInsetsControllerCompat(
                    window,
                    view
                ).show(WindowInsetsCompat.Type.systemBars())
            }
        }
    }

    fun getClockValue(): String {
        val simpleDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        return simpleDateFormat.format(Date())
    }

}