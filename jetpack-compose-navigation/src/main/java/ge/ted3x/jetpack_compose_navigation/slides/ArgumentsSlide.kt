package ge.ted3x.jetpack_compose_navigation.slides

import android.os.Parcelable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ge.ted3x.jetpack_compose_navigation.components.ExampleScreen
import ge.ted3x.jetpack_compose_navigation.components.SlideRoot
import ge.ted3x.jetpack_compose_navigation.components.SlideTitle
import kotlinx.parcelize.Parcelize

private const val ROUTE = "arguments"

fun NavGraphBuilder.argumentsSlide() {
    composable(ROUTE) {
        ArgumentsSlide()
    }
}

@Parcelize
data class TestData(val age: String): Parcelable

@Composable
private fun ArgumentsSlide(modifier: Modifier = Modifier) {
    SlideRoot(modifier) {
        SlideTitle(title = "Arguments in Navigation Component")

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = LOGIN_SCREEN) {
            composable(route = LOGIN_SCREEN) {
                LoginScreen(navController)
            }
            composable(
                route = "home_screen/{username}?age={age}",
                arguments = listOf(
                    navArgument("username") { type = NavType.StringType },
                    navArgument("age") { type = NavType.IntType; defaultValue = 0 },
                    navArgument("data") {
                        type = NavType.ParcelableType(TestData::class.java); nullable = true
                    })
            ) { backStackEntry ->
                val username = backStackEntry.arguments?.getString("username") ?: "NotFound"
                val age = backStackEntry.arguments?.getInt("age")!!
                HomeScreen(username, age)
            }
        }
    }
}

private const val LOGIN_SCREEN = "login_screen"

@Composable
private fun LoginScreen(navController: NavHostController) {
    ExampleScreen(title = "Login Screen") {
        var username by rememberSaveable { mutableStateOf("") }
        var age by rememberSaveable { mutableStateOf("") }

        Text(text = "You are on Login Screen")
        Spacer(modifier = Modifier.height(64.dp))
        TextField(value = username, onValueChange = { username = it }, label = {
            Text(text = "Username")
        })
        Spacer(modifier = Modifier.height(12.dp))
        TextField(value = age, onValueChange = { age = it }, label = {
            Text(text = "Age")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            navController.navigateToHome(
                username,
                if (age.isBlank()) null else age.toInt()
            )
        }) {
            Text(text = "Navigate to Home Screen")
        }
    }
}

fun NavController.navigateToHome(username: String, age: Int?) {
    var route = "home_screen/${username}"
    age?.let { route += "?age=$it" }
    navigate(route)
}

@Composable
private fun HomeScreen(username: String, age: Int) {
    ExampleScreen(title = "Home Screen") {
        Text(text = "Hi $username, you are on the Home Screen")
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "You are $age years old")
    }
}