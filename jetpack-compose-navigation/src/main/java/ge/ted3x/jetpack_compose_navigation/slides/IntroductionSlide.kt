package ge.ted3x.jetpack_compose_navigation.slides

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ge.ted3x.jetpack_compose_navigation.components.SlideRoot

@Composable
fun IntroductionSlide(modifier: Modifier = Modifier) {
    SlideRoot(modifier) {
        Text(
            text = "Jetpack Compose Integration",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Compose Navigation, duh",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(72.dp))

        Text(text = "By yours, Tedo Manvelidze", style = MaterialTheme.typography.titleLarge)
    }
}