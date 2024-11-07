package com.example.projectnews.presentation.screens.onboarding

data class OnboardingItem(
    val title: String,
    val description: String,
    val image: String,
)

val onboardingItems = listOf(
    OnboardingItem(
        title = "Find the best news",
        description = "Get the latest news from all over the world",
        image = "https://images.unsplash.com/photo-1531971588313-5f8f5b7f5d80?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
    ),
    OnboardingItem(
        title = "Get the latest news",
        description = "Get the latest news from all over the world",
        image = "https://images.unsplash.com/photo-1531971588313-5f8f5b7f5d80?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
    ),
    OnboardingItem(
        title = "Report the latest news",
        description = "Get the latest news from all over the world",
        image = "https://images.unsplash.com/photo-1531971588313-5f8f5b7f5d80?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
    ),
)
