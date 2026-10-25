package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = RoyalMaroonPrimaryDark,
    onPrimary = Color(0xFF450A0A),
    primaryContainer = RoyalMaroonDark,
    onPrimaryContainer = Color(0xFFFEE2E2),
    secondary = GoldenAmberSecondaryDark,
    onSecondary = Color(0xFF451A03),
    secondaryContainer = GoldenAmberDark,
    onSecondaryContainer = Color(0xFFFEF3C7),
    tertiary = DesertTealTertiaryDark,
    onTertiary = Color(0xFF042F2E),
    tertiaryContainer = DesertTealTertiary,
    onTertiaryContainer = Color(0xFFCCFBF1),
    background = DarkBackground,
    onBackground = Color(0xFFF3F4F6),
    surface = DarkSurface,
    onSurface = Color(0xFFF3F4F6),
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = Color(0xFFD1D5DB),
    outline = OutlineDark
)

private val LightColorScheme = lightColorScheme(
    primary = RoyalMaroonPrimary,
    onPrimary = Color.White,
    primaryContainer = RoyalMaroonContainer,
    onPrimaryContainer = OnRoyalMaroonContainer,
    secondary = GoldenAmberSecondary,
    onSecondary = Color.White,
    secondaryContainer = GoldenAmberContainer,
    onSecondaryContainer = OnGoldenAmberContainer,
    tertiary = DesertTealTertiary,
    onTertiary = Color.White,
    tertiaryContainer = DesertTealContainer,
    onTertiaryContainer = OnDesertTealContainer,
    background = WarmBackgroundLight,
    onBackground = Color(0xFF1F2937),
    surface = WarmSurfaceLight,
    onSurface = Color(0xFF1F2937),
    surfaceVariant = WarmSurfaceVariant,
    onSurfaceVariant = Color(0xFF4B5563),
    outline = OutlineWarm
)

@Composable
fun RajasthanQuizTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Set to false to preserve rich Rajasthani theme identity
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
        typography = Typography,
        content = content
    )
}
