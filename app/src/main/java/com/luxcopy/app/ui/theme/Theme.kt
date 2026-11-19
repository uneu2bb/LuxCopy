package com.luxcopy.app.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFFB8C4FF),
    onPrimary = androidx.compose.ui.graphics.Color(0xFF00208D),
    primaryContainer = androidx.compose.ui.graphics.Color(0xFF1A2B9E),
    onPrimaryContainer = androidx.compose.ui.graphics.Color(0xFFDDE1FF),
    secondary = androidx.compose.ui.graphics.Color(0xFFC1C5DD),
    tertiary = androidx.compose.ui.graphics.Color(0xFFE2BADA)
)

private val LightColorScheme = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF3D5AFE),
    onPrimary = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
    primaryContainer = androidx.compose.ui.graphics.Color(0xFFDDE1FF),
    onPrimaryContainer = androidx.compose.ui.graphics.Color(0xFF00115A),
    secondary = androidx.compose.ui.graphics.Color(0xFF5A5D72),
    tertiary = androidx.compose.ui.graphics.Color(0xFF7B5267)
)

@Composable
fun LuxCopyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}
