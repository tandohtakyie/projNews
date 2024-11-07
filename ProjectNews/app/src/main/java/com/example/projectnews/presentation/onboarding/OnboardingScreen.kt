package com.example.projectnews.presentation.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.projectnews.presentation.components.NewsButton
import com.example.projectnews.presentation.onboarding.components.Indicator
import com.example.projectnews.util.Dimens.PADDING200
import com.example.projectnews.util.Dimens.PADDING50
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    modifier: Modifier,
    scope: CoroutineScope,
) {

    val pagerState = rememberPagerState { onboardingItems.size }

    Column() {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = true,

            ) { currentPage ->

            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AsyncImage(
                    modifier = modifier
                        .size(PADDING200)
                        .align(alignment = Alignment.CenterHorizontally),
                    model = onboardingItems[currentPage].image,
                    contentDescription = onboardingItems[currentPage].title,
                )
                Text(onboardingItems[currentPage].title)
                Text(onboardingItems[currentPage].description)

                Indicator(
                    modifier = modifier.width(PADDING50),
                    pageSize = onboardingItems.size,
                    selectedPage = pagerState.currentPage,
                )

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
                        }
                    },
                )
            }

        }
    }
}