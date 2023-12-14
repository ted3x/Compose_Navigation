package ge.ted3x.jetpack_compose_navigation.slides

import android.content.Intent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ge.ted3x.jetpack_compose_navigation.MainActivity
import ge.ted3x.jetpack_compose_navigation.components.ExampleScreen
import ge.ted3x.jetpack_compose_navigation.components.SlideRoot
import ge.ted3x.jetpack_compose_navigation.components.SlideTitle

private const val ROUTE = "deeplinks"
val uri = "https://www.spacetest.ge"

fun NavGraphBuilder.deeplinksSlide() {
    composable(ROUTE) {
        DeeplinksSlide()
    }
}

@Composable
private fun DeeplinksSlide(modifier: Modifier = Modifier) {
    SlideRoot(modifier) {
        SlideTitle(title = "Deeplinks in Navigation Component")

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = LOGIN_SCREEN) {
            composable(route = LOGIN_SCREEN) {
                LoginScreen()
            }
        }
    }
}

private const val LOGIN_SCREEN = "login_screen"

@Composable
private fun LoginScreen() {
    ExampleScreen(title = "Login Screen") {
        val context = LocalContext.current
        Text(text = "You are on Login Screen")
        Spacer(modifier = Modifier.height(64.dp))
        Button(onClick = {
            val id = "exampleId"
            val deepLinkIntent = Intent(
                Intent.ACTION_VIEW,
                "https://www.spacetest.ge/$id".toUri(),
                context,
                MainActivity::class.java
            )

            context.startActivity(deepLinkIntent)

        }) {
            Text(text = "Let's browse some web")
        }
    }
}