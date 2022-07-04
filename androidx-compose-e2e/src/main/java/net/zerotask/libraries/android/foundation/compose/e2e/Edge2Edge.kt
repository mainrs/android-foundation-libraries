package net.zerotask.libraries.android.foundation.compose.e2e

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun Edge2Edge(
    darkIcons: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    Edge2Edge(
        statusBarDarkIcons = !darkIcons,
        navigationBarDarkIcons = darkIcons,
        content = content,
    )
}

@Composable
fun Edge2Edge(
    statusBarDarkIcons: Boolean,
    navigationBarDarkIcons: Boolean,
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = statusBarDarkIcons,
        )
        systemUiController.setNavigationBarColor(
            color = Color.Transparent,
            darkIcons = navigationBarDarkIcons,
        )
    }

    content()
}
