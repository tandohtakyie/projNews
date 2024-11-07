package com.example.projectnews.presentation.navgraph

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.projectnews.presentation.screens.onboarding.OnBoardingScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavGraph(
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
                OnBoardingScreen(
                    modifier = Modifier,
                    scope = scope,
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route,
        ) {
            composable(Route.NewsNavigationScreen.route) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = "News Navigator Screen")
                }
            }
        }
    }
}
