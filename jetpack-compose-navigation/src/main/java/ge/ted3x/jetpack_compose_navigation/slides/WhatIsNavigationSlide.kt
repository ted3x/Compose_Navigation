package ge.ted3x.jetpack_compose_navigation.slides

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ge.ted3x.jetpack_compose_navigation.components.BulletPoint
import ge.ted3x.jetpack_compose_navigation.components.ExampleScreen
import ge.ted3x.jetpack_compose_navigation.components.SlideRoot
import ge.ted3x.jetpack_compose_navigation.components.SlideTitle

private const val ROUTE = "whatisnavigation"

fun NavGraphBuilder.whatIsNavigation() {
    composable(ROUTE) {
        WhatIsNavigationSlide()
    }
}

@Composable
private fun WhatIsNavigationSlide(modifier: Modifier = Modifier) {
    SlideRoot(modifier) {
        val exampleType = remember {
            mutableStateOf<ExampleType?>(null)
        }
        SlideTitle(title = "What is Navigation?")

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                BulletPoint(text = "Destinations") { exampleType.value = ExampleType.Destinations }
                BulletPoint(text = "Navigation Graph") { exampleType.value = ExampleType.NavGraph }
                BulletPoint(text = "NavHost") { exampleType.value = ExampleType.NavHost }
                BulletPoint(text = "NavController") {
                    exampleType.value = ExampleType.NavController
                }
                BulletPoint(text = "Arguments") { exampleType.value = ExampleType.Arguments }
                BulletPoint(text = "Deeplinks") { exampleType.value = ExampleType.Deeplinks }
                BulletPoint(text = "Transitions") { exampleType.value = ExampleType.Transitions }
            }
            Spacer(modifier = Modifier.weight(1f))
            exampleType.value?.let { drawExample(it) }
        }
    }
}

enum class ExampleType {
    Destinations,
    NavGraph,
    NavHost,
    NavController,
    Arguments,
    Deeplinks,
    Transitions
}

@Composable
fun drawExample(exampleType: ExampleType) {
    when (exampleType) {
        ExampleType.Destinations -> DestinationsExample()
        ExampleType.NavGraph -> NavGraphExample()
        ExampleType.NavHost -> NavHostExample()
        ExampleType.NavController -> NavControllerExample()
        ExampleType.Arguments -> ArgumentsExample()
        ExampleType.Deeplinks -> DeeplinksExample()
        ExampleType.Transitions -> TransitionsExample()
    }
}

@Composable
fun DestinationsExample() {
    ExampleScreen(title = "Destinations") {
        Text(
            text = "Destinations are the individual screens or views that users can navigate to within your app. Each destination corresponds to a composable function in Jetpack Compose.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "In the navigation graph, destinations are the nodes that you define, each representing a piece of content or a different state of your app.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Each destination is identified by a unique route string. This string is used when defining the navigation graph and when navigating between destinations.",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun NavGraphExample() {
    ExampleScreen(title = "NavGraph") {
        Text(
            text = "You can think of NavGraph as graph which includes all possible destinations within itself",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            "A navigation graph is a set of rules and paths that define the navigation flow in an app.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "It outlines all the possible destinations (screens) a user can navigate to and the relationships between these destinations.",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun NavHostExample() {
    ExampleScreen(title = "NavHost") {
        Text(
            text = "You can think of NavHost as container which will display destinations (screens)",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            "The NavHost is a composable function that hosts the navigation graph. It acts as the container for the screens or destinations defined in your navigation graph.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "It's the central hub where the content of each destination is displayed as users navigate through the app.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "NavHost works closely with the NavController. While the NavController manages the navigation logic and back stack, the NavHost displays the appropriate composable screen based on the current state of the navigation.",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun ArgumentsExample() {
    ExampleScreen(title = "Arguments") {
        Text(
            text = "Arguments in navigation allow you to pass data between different destinations (composables/screens) in your app. They are used to transfer necessary information from one screen to another",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            "When defining a destination in the navigation graph, you can specify arguments that the destination expects to receive.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Arguments can be mandatory or optional with default value or null",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Arguments can be various types, such as primitives or complex, such as custom Parcelize",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "* Even though you can pass complex data objects between screens, it's not recommended since it can cause data inconsistencies during recreation",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Red
        )
        Text(
            text = "* Prefer to pass minimal data such as ID, then retrieve your data based on that ID from local sources",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Red
        )
    }
}

@Composable
fun DeeplinksExample() {
    ExampleScreen(title = "Deeplinks") {
        Text(
            text = "Deep links allow your app to handle URLs or intents that direct the user to specific content or screens within your app. They are essential for integrating your app with other apps and web links.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            "You can define deep links in your navigation graph, associating a specific URL or URI pattern with a destination.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "When your app is opened via a deep link, the Navigation component parses the URL and navigates to the corresponding destination, optionally passing along any data from the URL as arguments.",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun NavControllerExample() {
    ExampleScreen(title = "NavController") {
        Text(
            text = "The NavController is responsible for orchestrating the navigation between different composables or screens within a NavHost. It manages the navigation stack, handling the operations to navigate forward to a new screen, or backward to a previous screen.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            "It keeps track of the app's navigation history in a back stack, ensuring that navigation actions like pressing the back button behave as expected.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "NavController provides functions to perform navigation actions, such as navigate(), popBackStack(), and navigateUp().\n" +
                    "It allows for complex navigational structures, such as conditional navigation, nested graphs, and deep linking.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "It facilitates the passing of data between destinations using arguments.",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun TransitionsExample() {
    ExampleScreen(title = "Transitions") {
        Text(
            text = "Transitions are used to animate the change from one composable (screen) to another within the navigation graph. They help create a seamless and intuitive flow through the app.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        BulletPoint(text = "Default Transitions: Jetpack Compose Navigation comes with default transitions for navigating between composables, like simple fades or slide animations.")
        BulletPoint(text = "Custom Transitions: You can create custom transitions to suit the style and needs of your app. This can include more complex animations, like shared element transitions.")
    }
}