package com.example.projectnews.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.projectnews.ui.theme.PrimaryColor
import com.example.projectnews.util.Dimens.PADDING15

@Composable
fun Indicator(
    modifier: Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = PrimaryColor,
    unselectedColor: Color = Color.Red,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        repeat(pageSize) { page ->
            Box(
                modifier = modifier
                    .size(PADDING15)
                    .clip(CircleShape)
                    .background(color = if (page == selectedPage) selectedColor else unselectedColor)

            )
        }
    }

}