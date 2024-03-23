package ke.co.fiti.foodexpress.presentation.navigation

import android.util.Log
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ke.co.fiti.foodexpress.presentation.screens.authentication.CreateAccountScreen
import ke.co.fiti.foodexpress.presentation.screens.authentication.LoginScreen
import ke.co.fiti.foodexpress.presentation.screens.home.HomeViewModel
import ke.co.fiti.foodexpress.presentation.screens.onboardng.AuthOrientationScreen
import ke.co.fiti.foodexpress.presentation.screens.onboardng.OnboardingScreen

@Composable
fun FoodExpressNavigationGrapgh(
    preferencesViewModel: UpdatePreferencesViewModel
) {
    val mainNavController = rememberNavController()
    val viewModel: NavViewModel = hiltViewModel()
    val homeViewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.isSigningInFinished.collectAsState()
    val navToHomeState by viewModel.isReadyForHome.collectAsState()
    val loadState by viewModel.loadState.collectAsState()
    var startDestination: String by remember { mutableStateOf(Routes.LOADING.name) }
    LaunchedEffect(key1 = state, key2 = loadState) {
        startDestination = if (loadState is CurrentCondition.Loading) {
            Routes.LOADING.name
        } else {
            if (state) {
                if (navToHomeState) {
                    Routes.HOME.name
                } else {
                    Routes.CREATEACCOUNT.name
                }
            } else {
                Routes.ORIENTATION.name
            }
        }
        Log.d(
            "Thrive Back Navigation",
            "AppNavGraph: the isTokenViewModel state updated... " +
                    "\n" +
                    "isOnboardingFinished:" + "${viewModel.isSigningInFinished}" +
                    "startDestination:" +
                    "${startDestination}" + "LoadState : $loadState State: $state What the if generates: " + if (loadState is CurrentCondition.Loading) {
                Routes.LOADING.name
            } else {
                Routes.CREATEACCOUNT.name
            }
        )

    }
    val timeInMillis = 300

    NavHost(
        navController = mainNavController,
        startDestination = Routes.ORIENTATION.name,
    ) {
        composable(
            route = Routes.LOADING.name,
            popEnterTransition = popEnter(timeInMillis),
            popExitTransition = popExit(timeInMillis),
            enterTransition = slideInto(timeInMillis),
            exitTransition = exitTransition(timeInMillis)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "FoodExpress", style = MaterialTheme.typography.displaySmall)
                    Spacer(modifier = Modifier.height(12.dp))
                    CircularProgressIndicator(modifier = Modifier.size(36.dp))

                }

            }
        }
        composable(
            route = Routes.ONBOARDING.name,
            popEnterTransition = popEnter(timeInMillis),
            popExitTransition = popExit(timeInMillis),
            enterTransition = slideInto(timeInMillis),
            exitTransition = exitTransition(timeInMillis)
        ) {
            OnboardingScreen(navController = mainNavController)
        }

        composable(
            route = Routes.ORIENTATION.name,
            popEnterTransition = popEnter(timeInMillis),
            popExitTransition = popExit(timeInMillis),
            enterTransition = slideInto(timeInMillis),
            exitTransition = exitTransition(timeInMillis)
        ) {
            AuthOrientationScreen(
                navController = mainNavController,
                navigateToLoginScreen = { mainNavController.navigate(Routes.CREATEACCOUNT.name) },
            ) { mainNavController.navigate(Routes.LOGIN.name) }
        }
        composable(
            route = Routes.HOME.name,
            popEnterTransition = popEnter(timeInMillis),
            popExitTransition = popExit(timeInMillis),
            enterTransition = slideInto(timeInMillis),
            exitTransition = exitTransition(timeInMillis)
        ) {
            BottomNavGraph(homeViewmodel = homeViewModel)
        }
        composable(
            route = Routes.CREATEACCOUNT.name,
            popEnterTransition = popEnter(timeInMillis),
            popExitTransition = popExit(timeInMillis),
            enterTransition = slideInto(timeInMillis),
            exitTransition = exitTransition(timeInMillis)
        ) {
            CreateAccountScreen(navController = mainNavController)
        }
        composable(
            route = Routes.LOGIN.name,
            popEnterTransition = popEnter(timeInMillis),
            popExitTransition = popExit(timeInMillis),
            enterTransition = slideInto(timeInMillis),
            exitTransition = exitTransition(timeInMillis)
        ) {
            LoginScreen(
                navController = mainNavController,
                navigateToHomeScreen = { mainNavController.navigate(Routes.HOME.name) },
                preferencesViewModel = preferencesViewModel
            )
        }
//        composable(
//            route = Routes.INSIGHTS.name,
//            popEnterTransition = popEnter(timeInMillis),
//            popExitTransition = popExit(timeInMillis),
//            enterTransition = slideInto(timeInMillis),
//            exitTransition = exitTransition(timeInMillis)
//        ) {
//            InsightScreen(navController = mainNavController)
//        }


    }

}


val easing: Easing = EaseIn
fun popExit(timeInMillis: Int): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) {
    return {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Right,
            animationSpec = tween(
                durationMillis = timeInMillis,
                easing = easing
            )
        )
    }
}

fun slideInto(timeInMillis: Int): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) {
    return {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(
                durationMillis = timeInMillis,
                easing = easing
            )
        )
    }
}

fun exitTransition(timeInMillis: Int): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) {
    return {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(
                durationMillis = timeInMillis + 50,
                easing = easing
            )
        )
    }
}

fun popEnter(timeInMillis: Int): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) {
    return {
        slideIntoContainer(

            AnimatedContentTransitionScope.SlideDirection.Right,

            animationSpec = tween(
                durationMillis = timeInMillis,
                easing = easing
            )
        )
    }

}


