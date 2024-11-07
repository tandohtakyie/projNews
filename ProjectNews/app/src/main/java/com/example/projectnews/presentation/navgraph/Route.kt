package com.example.projectnews.presentation.navgraph

sealed class Route(
    val route: String,
) {
    object OnBoardingScreen : Route("onBoardingScreen")
    object HomeScreen : Route("homeScreen")
    object DetailScreen : Route("detailScreen")
    object SearchScreen : Route("searchScreen")
    object BookmarkedScreen : Route("bookmarkScreen")
    object AppStartNavigation : Route("appStartNavigation")
    object NewsNavigation : Route("newsNavigation")
    object NewsNavigationScreen : Route("newsNavigationScreen")
}