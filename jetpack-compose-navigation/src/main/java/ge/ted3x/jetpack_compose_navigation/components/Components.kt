package ge.ted3x.jetpack_compose_navigation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SlideRoot(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content.invoke()
    }
}

@Composable
fun SlideTitle(title: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = title,
        style = MaterialTheme.typography.displayMedium,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun BulletPoint(text: String, onClick: (() -> Unit)? = null) {
    Row(onClick?.let { Modifier.clickable(onClick = it) } ?: Modifier) {
        Text(
            text = "•",
            modifier = Modifier.align(Alignment.CenterVertically),
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun Action(text: String, action: () -> Unit) {
    Button(onClick = action) {
        Text(text = text)
    }
}

@Composable
fun LocalScreen(title: String, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier
            .padding(64.dp)
            .wrapContentSize()
            .defaultMinSize(360.dp, 360.dp),
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title)
            Spacer(modifier = Modifier.height(16.dp))
            content.invoke()
        }
    }
}

@Composable
fun ExampleScreen(title: String, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier
            .padding(64.dp)
            .wrapContentSize(),
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            content.invoke()
        }
    }
}