package ge.ted3x.jetpack_compose_navigation.slides

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ge.ted3x.jetpack_compose_navigation.components.ExampleScreen
import ge.ted3x.jetpack_compose_navigation.components.SlideRoot
import ge.ted3x.jetpack_compose_navigation.components.SlideTitle

private const val ROUTE = "destinations"

fun NavGraphBuilder.destinationsSlide() {
    composable(ROUTE) {
        DestinationsSLide()
    }
}

@Composable
private fun DestinationsSLide(modifier: Modifier = Modifier) {
    SlideRoot(modifier) {
        SlideTitle(title = "Destinations in Navigation Component")

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = LOGIN_SCREEN) {
            composable(route = LOGIN_SCREEN) {
                LoginScreen(navController)
            }
            composable(route = HOME_SCREEN) {
                HomeScreen()
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
    }
}

private const val HOME_SCREEN = "home_screen"

@Composable
private fun HomeScreen() {
    ExampleScreen(title = "Home Screen") {
        Text(text = "Yay! You are on the Home Screen")
    }
}