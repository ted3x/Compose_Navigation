package ge.ted3x.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

const val LOGIN_ROUTE = "login"

fun NavGraphBuilder.loginGraph() {
    navigation("login_username", LOGIN_ROUTE) {
        composable("login_username") {

        }
        composable("login_password") {

        }
    }
}

// Implementation details of how we navigate to login stays within login module
// We just expose API for navigation

// This also gives us possibility to have type safety of args during navigation
// because we declare what kind of args does Login need
fun NavController.navigateToLogin(id: String) {
    navigate("$LOGIN_ROUTE/$id") {
        launchSingleTop = true
    }
}