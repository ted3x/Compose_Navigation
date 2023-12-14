package ge.ted3x.jetpack_compose_navigation.slides

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import ge.ted3x.jetpack_compose_navigation.components.ExampleScreen
import ge.ted3x.jetpack_compose_navigation.components.SlideRoot
import ge.ted3x.jetpack_compose_navigation.components.SlideTitle

private const val ROUTE = "nested_navigation"

fun NavGraphBuilder.nestedNavigation() {
    composable(ROUTE) {
        NestedNavigationSlide()
    }
}

@Composable
private fun NestedNavigationSlide(modifier: Modifier = Modifier) {
    SlideRoot(modifier) {
        SlideTitle(title = "Nested Navigation in Navigation Component")

        val navController = rememberNavController()
        Button(onClick = { navController.navigate("login") }) {
            Text(text = "Let's go to Login Flow")
        }
        Button(onClick = { navController.navigate("registration") }) {
            Text(text = "Let's go to Registration Flow")
        }
        NavHost(navController = navController, startDestination = "login") {
            // Routes should be unique, if duplicated it might cause bugs
            // That's why we have prefixes such as login_ and registration_
            navigation(startDestination = "login_username", route = "login") {
                composable(route = "login_username") {
                    LoginUsernameScreen(navController = navController)
                }
                composable(route = "login_password") {
                    LoginPasswordScreen()
                }
            }
            navigation(startDestination = "registration_username", route = "registration") {
                composable(route = "registration_username") {
                    RegistrationUsernameScreen(navController = navController)
                }
                composable(route = "registration_password") {
                    RegistrationPasswordScreen()
                }
            }
        }
    }
}

@Composable
private fun LoginUsernameScreen(navController: NavController) {
    ExampleScreen(title = "Login Username") {
        Text(text = "This is Login Username screen")
        Button(onClick = { navController.navigate("login_password") }) {
            Text(text = "Let's go to password")
        }
    }
}

@Composable
private fun LoginPasswordScreen() {
    ExampleScreen(title = "Login Password") {
        Text(text = "This is Login Password screen")
    }
}

@Composable
private fun RegistrationUsernameScreen(navController: NavController) {
    ExampleScreen(title = "Registration Username") {
        Text(text = "This is Registration Username screen")
        Button(onClick = { navController.navigate("registration_password") }) {
            Text(text = "Let's go to password")
        }
    }
}

@Composable
private fun RegistrationPasswordScreen() {
    ExampleScreen(title = "Registration Password") {
        Text(text = "This is Registration Password screen")
    }
}