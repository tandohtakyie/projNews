package com.example.projectnews.presentation.navgraph

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.projectnews.presentation.screens.home.HomeScreen
import com.example.projectnews.presentation.screens.home.HomeViewModel
import com.example.projectnews.presentation.screens.onboarding.OnBoardingScreen
import com.example.projectnews.presentation.screens.onboarding.OnboardingViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavGraph(
    modifier: Modifier,
    context: Context,
    scope: CoroutineScope,
    startDestination: String,
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route,
        ) {
            composable(Route.OnBoardingScreen.route) {
                val viewModel: OnboardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    modifier = Modifier,
                    scope = scope,
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route,
        ) {
            composable(Route.NewsNavigationScreen.route) {
                val viewModel: HomeViewModel = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    modifier = modifier,
                    articles = articles,
                    context = context,
                    navigate = { }
                )
            }
        }
    }
}
