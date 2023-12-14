package ge.ted3x.registration

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

const val REGISTRATION_ROUTE = "registration"

fun NavGraphBuilder.registrationGraph(navigateToLogin: () -> Unit) {
    navigation("registration_username", REGISTRATION_ROUTE) {
        composable("registration_username") {
            navigateToLogin()
        }
        composable("registration_password") {

        }
    }
}