package io.github.kawaki.yast.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    fun goToHomeFragment(navController: NavController, route: Int, delayMillis: Long) {
        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(route)
        }, delayMillis)
    }

}