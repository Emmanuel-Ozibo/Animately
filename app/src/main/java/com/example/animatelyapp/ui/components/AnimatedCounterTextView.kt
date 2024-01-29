package com.example.animatelyapp.ui.components

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.green
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun AnimatedCounterTextView(value: Int) {

    var targetValue by remember { mutableIntStateOf(0) }


    val animatedValue by animateIntAsState(targetValue = targetValue, label = "intAmin",
        animationSpec = tween(durationMillis = 300)
    )


    LaunchedEffect("value") {
        CoroutineScope(Dispatchers.Main).launch {
            val timesToItrate = value / 10
            for (i in 0..timesToItrate) {
                targetValue =+ i * 10
                delay(10)
            }
        }
    }

    targetValue = value

    Row (verticalAlignment = Alignment.Bottom){
        Text(
            text = "$animatedValue",
            color = green,
            style = MaterialTheme.typography.displaySmall
        )

        Text(
            modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
            text = "USD",
            color = green,
            style = MaterialTheme.typography.titleLarge)


    }

}


@Preview
@Composable
private fun AnimatedCounterTextViewPreview() {
    AnimatelyAppTheme {
        AnimatedCounterTextView(3000)
    }
}