package ge.ted3x.jetpack_compose_navigation.slides

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ge.ted3x.jetpack_compose_navigation.components.Action
import ge.ted3x.jetpack_compose_navigation.components.LocalScreen
import ge.ted3x.jetpack_compose_navigation.components.SlideRoot
import ge.ted3x.jetpack_compose_navigation.components.SlideTitle

private const val ROUTE = "navcontroller"

fun NavGraphBuilder.navControllerSlide(navController: NavController) {
    composable(ROUTE) {
        NavControllerSlide()
    }
}

@Composable
private fun NavControllerSlide(modifier: Modifier = Modifier) {
    SlideRoot(modifier) {
        SlideTitle(title = "NavController in Navigation Component")
        Spacer(modifier = Modifier.height(12.dp))

        val navController = rememberNavController()
        val message = remember { mutableStateOf("") }

        ResetButtons(navController = navController)
        Column {
            ErrorText(message = message.value) { message.value = "" }
            navController.BackStackInfo()
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            NavHost(navController = navController, startDestination = "first") {
                firstScreen(navController)
                secondScreen(navController)
                thirdScreen(navController) { message.value = it }
                fourthScreen()
            }
            Spacer(modifier = Modifier.width(32.dp))
        }

    }
}

fun NavGraphBuilder.firstScreen(navController: NavController) {
    composable("first") {
        LocalScreen(title = "First") {
            val counter = rememberSaveable { mutableIntStateOf(0) }
            Text(text = "Counter: ${counter.value}")
            Action("Navigate to Second") {
                navController.navigate("second")
            }
            Action("Navigate to Third") {
                navController.navigate("third")
            }
            Button(onClick = { counter.value++ }) {
                Text(text = "Increment")
            }
        }
    }
}

fun NavGraphBuilder.secondScreen(navController: NavController) {
    composable("second") {
        LocalScreen(title = "Second") {
            Action(text = "Navigate to second with launchSingleTop") {
                navController.navigate("second") {
                    launchSingleTop = true
                }
            }
            Action(text = "Navigate to second") {
                navController.navigate("second") {
                    launchSingleTop = false
                }
            }
            Action(text = "Back to First") {
                navController.popBackStack()
            }
        }
    }
}

fun NavGraphBuilder.thirdScreen(navController: NavController, showMessage: (String) -> Unit) {
    composable("third") {
        LocalScreen(title = "Third") {
            Action(text = "Back to First") {
                navController.popBackStack("first", false)
            }

            Action(text = "Back to First with inclusive") {
                navController.popBackStack("first", true)
            }

            Action(text = "Back to Second") {
                if (!navController.popBackStack("second", false)) {
                    showMessage.invoke("Could not pop back to Second, because it was not in BackStack")
                }
            }

            Action(text = "Navigate to fourth with inclusive + save State") {
                navController.navigate("fourth") {
                    popUpTo("first") {
                        inclusive = true
                        saveState = true
                    }
                }
            }

            Action(text = "Navigate to fourth") {
                navController.navigate("fourth") {
                    popUpTo("first") { inclusive = false }
                }
            }
        }
    }
}

fun NavGraphBuilder.fourthScreen() {
    composable("fourth") {
        LocalScreen(title = "Fourth") {
            Text(text = "Yay, you reached the last screen")
        }
    }
}

@Composable
fun NavController.BackStackInfo() {
    val currentBackStack = currentBackStack.collectAsState()
    Text(
        text = "Current BackStack entries: ${
            currentBackStack.value.slice(
                IntRange(
                    1,
                    currentBackStack.value.size - 1
                )
            ).joinToString { it.destination.route.toString() }
        }",
        style = MaterialTheme.typography.headlineMedium,
    )
}

@Composable
fun ErrorText(message: String, clearMessage: () -> Unit) {
    Text(
        text = message,
        color = Color.Red,
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.clickable(onClick = clearMessage)
    )
}

@Composable
private fun ResetButtons(navController: NavController) {
    Button(onClick = {
        navController.navigate("first") {
            popUpTo(navController.graph.id) { inclusive = true }
        }
    }) {
        Text(text = "Reset")
    }
    Button(onClick = {
        navController.navigate("first") {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
            restoreState = true
        }
    }) {
        Text(text = "Reset with Saved State")
    }
}