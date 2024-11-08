package com.example.projectnews.presentation.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.projectnews.presentation.components.NewsButton
import com.example.projectnews.ui.theme.WhiteColor
import com.example.projectnews.util.Dimens.PADDING15
import com.example.projectnews.util.Dimens.PADDING50
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    modifier: Modifier,
    scope: CoroutineScope,
    event: (OnboardingEvent) -> Unit,
) {

    val pagerState = rememberPagerState { onboardingItems.size }

    HorizontalPager(
        state = pagerState,
        userScrollEnabled = true,
    ) { currentPage ->

        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Image(
                modifier = modifier
                    .fillMaxSize()
                    .drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = size.height / 90f,
                            endY = size.height
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient, blendMode = BlendMode.Multiply)
                        }
                    },
                painter = painterResource(id = onboardingItems[currentPage].image),
                contentScale = ContentScale.Crop,
                contentDescription = onboardingItems[currentPage].title,
            )

            Column {
                Text(
                    text = onboardingItems[currentPage].title,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = WhiteColor,
                )
                Text(
                    text = onboardingItems[currentPage].description,
                    color = WhiteColor,
                )
                Spacer(modifier = modifier.height(PADDING15))
                NewsButton(
                    modifier = modifier,
                    text = if (pagerState.currentPage != (onboardingItems.size - 1)) "Next" else "Get Started",
                    onClick = {
                        if (pagerState.currentPage != (onboardingItems.size - 1)) {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        } else {
                            // navigate to home screen
                            event(OnboardingEvent.SaveAppEntry)
                        }
                    },
                )
                Spacer(modifier = modifier.height(PADDING50))
            }
        }
    }
}