package org.com.testmatemultiplatform.core.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.com.testmatemultiplatform.core.theme.rubikFontFamily
import org.com.testmatemultiplatform.core.theme.titleTextColor


@Composable
fun HeadlineLargeTextView(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = titleTextColor,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 24.sp
    )
}


@Composable
fun HeadlineMediumTextView(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = titleTextColor,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 22.sp
    )
}

@Composable
fun HeadlineSmallTextView(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = titleTextColor,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 20.sp
    )
}

@Composable
fun TitleLargeTextView(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = titleTextColor,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 20.sp
    )
}

@Composable
fun TitleMediumTextView(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = titleTextColor,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 18.sp,
    )
}

@Composable
fun TitleSmallTextView(
    text: String,
    color: Color = titleTextColor,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp
    )
}


@Composable
fun BodyLargeTextView(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = titleTextColor,
    textAlign: TextAlign = TextAlign.Start,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = fontWeight,
        fontSize = 16.sp,
        lineHeight = 18.sp
    )
}

@Composable
fun BodyMediumTextView(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = titleTextColor,
    textAlign: TextAlign = TextAlign.Start,
    fontWeight: FontWeight = FontWeight.Normal,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = fontWeight,
        fontSize = 14.sp,
        lineHeight = 16.sp
    )
}

@Composable
fun BodySmallTextView(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = titleTextColor,
    textAlign: TextAlign = TextAlign.Start,
    fontWeight: FontWeight = FontWeight.Normal,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = fontWeight,
        fontSize = 12.sp,
        lineHeight = 14.sp
    )
}

@Composable
fun LabelLargeTextView(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Light,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = fontWeight,
        fontSize = 14.sp,
        lineHeight = 16.sp
    )
}

@Composable
fun LabelMediumTextView(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Light,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = fontWeight,
        fontSize = 12.sp,
        lineHeight = 14.sp
    )
}

@Composable
fun LabelSmallTextView(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Light,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontFamily = rubikFontFamily(),
        fontWeight = fontWeight,
        fontSize = 10.sp,
        lineHeight = 12.sp
    )
}