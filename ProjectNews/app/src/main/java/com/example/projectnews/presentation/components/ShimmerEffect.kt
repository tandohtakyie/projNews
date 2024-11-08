package com.example.projectnews.presentation.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.projectnews.R
import com.example.projectnews.ui.theme.PrimaryColor
import com.example.projectnews.util.Dimens.ARTICLE_CARD_SIZE
import com.example.projectnews.util.Dimens.PADDING5

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition(label = "")
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    ).value
    background(color = PrimaryColor.copy(alpha = alpha))
}

@Composable
fun ArticleCardShimmer(
    modifier: Modifier
) {
    Row(modifier = modifier) {
        Box(
            modifier = modifier
                .size(ARTICLE_CARD_SIZE)
                .clip(shape = RoundedCornerShape(PADDING5))
                .shimmerEffect()
        )

        Column(

        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = PADDING5)
                    .shimmerEffect()
            )

            Row() {
                Box(
                    modifier = modifier
                        .fillMaxWidth(0.5f)
                        .height(15.dp)
                        .padding(horizontal = PADDING5)
                        .shimmerEffect()
                )
            }
        }
    }
}