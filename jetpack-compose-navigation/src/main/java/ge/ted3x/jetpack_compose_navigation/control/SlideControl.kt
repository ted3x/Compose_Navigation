package ge.ted3x.jetpack_compose_navigation.control

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ge.ted3x.jetpack_compose_navigation.Hierarchy

@Composable
fun SlideController(
    hierarchy: Hierarchy,
    onNextClick: (destination: String) -> Unit,
    onPreviousClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        if (hierarchy.previous != null) {
            Spacer(modifier = Modifier.width(32.dp))
            Button(onClick = onPreviousClick) {
                Text("Previous")
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        if (hierarchy.next != null) {
            Button(onClick = { onNextClick.invoke(hierarchy.next) }) {
                Text("Next")
            }
            Spacer(modifier = Modifier.width(32.dp))
        }
    }
}