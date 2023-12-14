package ge.ted3x.jetpack_compose_navigation.slides

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ge.ted3x.jetpack_compose_navigation.components.ExampleScreen
import ge.ted3x.jetpack_compose_navigation.components.SlideRoot
import ge.ted3x.jetpack_compose_navigation.components.SlideTitle

private const val ROUTE = "navhost"

fun NavGraphBuilder.navHostSlide() {
    composable(ROUTE) {
        NavHostSlide()
    }
}

@Composable
private fun NavHostSlide(modifier: Modifier = Modifier) {
    SlideRoot(modifier) {
        SlideTitle(title = "NavHost + NavGraph in Navigation Component")

        val navController = rememberNavController()

        NavHost(navController = navController, modifier = Modifier.background(Color.Magenta).padding(32.dp), startDestination = LOGIN_SCREEN, enterTransition = {
            fadeIn()
        }, exitTransition = {
            fadeOut()
        }) {
            composable(route = LOGIN_SCREEN) {
                LoginScreen(navController)
            }
            composable(route = ONBOARDING_SCREEN) {
                OnboardingScreen(navController)
            }
            composable(route = HOME_SCREEN, enterTransition = {
                expandHorizontally()
            }, exitTransition = {
                shrinkHorizontally()
            }) {
                HomeScreen(navController)
            }
        }

    }
}

private const val LOGIN_SCREEN = "login_screen"

@Composable
private fun LoginScreen(navController: NavHostController) {
    ExampleScreen(title = "Login Screen") {
        Text(text = "You are on Login Screen")
        Spacer(modifier = Modifier.height(64.dp))
        Button(onClick = { navController.navigate(HOME_SCREEN) }) {
            Text(text = "Navigate to Home Screen")
        }
        Button(onClick = { navController.navigate(ONBOARDING_SCREEN) }) {
            Text(text = "Navigate to Onboarding Screen")
        }
    }
}

private const val ONBOARDING_SCREEN = "onboarding_screen"

@Composable
private fun OnboardingScreen(navController: NavHostController) {
    ExampleScreen(title = "Onboarding Screen") {
        Text(text = "You are on Onboarding Screen")
        Spacer(modifier = Modifier.height(64.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go Back to Login Screen")
        }
    }
}

private const val HOME_SCREEN = "home_screen"

@Composable
private fun HomeScreen(navController: NavHostController) {
    ExampleScreen(title = "Home Screen") {
        Text(text = "Yay! You are on the Home Screen")
        Spacer(modifier = Modifier.height(64.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go Back to Login Screen")
        }
    }
}