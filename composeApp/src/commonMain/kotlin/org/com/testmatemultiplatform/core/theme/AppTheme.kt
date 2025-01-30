package org.com.testmatemultiplatform.core.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import testmatemultiplatform.composeapp.generated.resources.Res
import testmatemultiplatform.composeapp.generated.resources.hind_light
import testmatemultiplatform.composeapp.generated.resources.hind_medium
import testmatemultiplatform.composeapp.generated.resources.hind_regular
import testmatemultiplatform.composeapp.generated.resources.hind_semibold


val titleTextColor = Color(0xFF282828)
val textSubTitleColor = Color(0xFF5F5F5F)
val greyTextColor = Color(0xff424242)
val greyActiveColor = Color(0xFFA5A5A5)
val blackBackGroundColor = Color(0xFF313131)
val primaryButtonColor = Color(0xFF0A84FF)
val backgroundColor = Color(0xFFDBDBDB)
val switchInactiveColor = Color(0xFF757575)
val switchActiveColor = Color(0xFF0A84FF)
val borderColor = Color(0xFFD1D1D1)
val hintColor = Color(0xFF696969)
val whiteColor = Color(0xFFFFFFFF)
val blue10 = Color(0x19529AD6)
val whiteBgColor = Color(0xFFF6F6F6)
//val titleTextColor = Color(0xFFEAEAEA)
//val textSubTitleColor = Color(0xFFBEBEBE)
//val greyTextColor = Color(0xFFB8B8B8)
//val greyActiveColor = Color(0xFF909090)
//val blackBackGroundColor = Color(0xFF121212)
//val primaryButtonColor = Color(0xFF0A84FF)
//val backgroundColor = Color(0xFF1C1C1C)
//val switchInactiveColor = Color(0xFF505050)
//val switchActiveColor = Color(0xFF0A84FF)
//val borderColor = Color(0xFF3A3A3A)
//val hintColor = Color(0xFF8E8E8E)
//val whiteColor = Color(0xFF151515)


@Composable
fun rubikFontFamily() = FontFamily(
    Font(Res.font.hind_light, weight = FontWeight.Light),
    Font(Res.font.hind_regular, weight = FontWeight.Normal),
    Font(Res.font.hind_medium, weight = FontWeight.Medium),
    Font(Res.font.hind_semibold, weight = FontWeight.SemiBold),
)

@Composable
fun RubikTypography() = Typography().apply {
    val fontFamily = rubikFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}