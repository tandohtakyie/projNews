package com.example.projectnews.presentation.screens.onboarding

import com.example.projectnews.R

data class OnboardingItem(
    val title: String,
    val description: String,
    val image: Int,
)

val onboardingItems = listOf(
    OnboardingItem(
        title = "Find the best news",
        description = "Get the latest news from all over the world",
        image = R.drawable.onboarding_1,
     ),
    OnboardingItem(
        title = "Get the latest news",
        description = "Get the latest news from all over the world",
        image = R.drawable.onboarding_2,
    ),
    OnboardingItem(
        title = "Report the latest news",
        description = "Get the latest news from all over the world",
        image = R.drawable.onboarding_3,
     ),
)
