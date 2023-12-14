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

private const val ROUTE = "best_practices"

fun NavGraphBuilder.bestPractices() {
    composable(ROUTE) {
        BestPracticesSlide()
    }
}

@Composable
private fun BestPracticesSlide(modifier: Modifier = Modifier) {
    SlideRoot(modifier) {
        SlideTitle(title = "Best Practices")

        BulletPoint(text = "Use descriptive and unique route names to avoid confusion and potential conflicts, especially in large apps with many screens.")
        Spacer(modifier = Modifier.height(8.dp))
        BulletPoint(text = "Use Arguments Wisely. Pass only essential data through arguments. Avoid passing large or complex data objects.")
        Spacer(modifier = Modifier.height(8.dp))
        BulletPoint(text = "Modularize Navigation Graphs. For complex applications, break down the navigation graph into smaller, modular graphs. This can be especially helpful in feature-modularized projects.")
        Spacer(modifier = Modifier.height(8.dp))
        BulletPoint(text = "Keep Navigation Logic Decoupled. Avoid tightly coupling navigation logic with your UI components. Use NavController to handle navigation actions.Decouple navigation logic from business logic for better maintainability and testing.")
    }
}