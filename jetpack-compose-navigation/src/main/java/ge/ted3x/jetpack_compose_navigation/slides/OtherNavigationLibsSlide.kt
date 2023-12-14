package ge.ted3x.jetpack_compose_navigation.slides

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ge.ted3x.jetpack_compose_navigation.components.SlideRoot
import ge.ted3x.jetpack_compose_navigation.components.SlideTitle

private const val ROUTE = "other_navigation_libs"

fun NavGraphBuilder.otherNavigationLibs() {
    composable(ROUTE) {
        OtherNavigationLibsSlide()
    }
}

@Composable
private fun OtherNavigationLibsSlide(modifier: Modifier = Modifier) {
    SlideRoot(modifier) {
        SlideTitle(title = "3rd Party Navigation Libraries")

        Text(text = "Appyx", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Link: https://github.com/bumble-tech/appyx", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Compose Destinations", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Link: https://github.com/raamcosta/compose-destinations", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Decompose", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Link: https://github.com/arkivanov/Decompose", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Voyager", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Link: https://github.com/adrielcafe/voyager", style = MaterialTheme.typography.headlineSmall)
    }
}