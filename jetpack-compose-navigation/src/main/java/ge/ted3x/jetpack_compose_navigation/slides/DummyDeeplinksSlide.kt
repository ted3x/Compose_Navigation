package ge.ted3x.jetpack_compose_navigation.slides

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ge.ted3x.jetpack_compose_navigation.components.SlideRoot

@Composable
fun DummySlide(id: String?, modifier: Modifier = Modifier) {
    SlideRoot(modifier) {
        Text(
            text = "Deeplink worked, you are here now with id = $id",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}