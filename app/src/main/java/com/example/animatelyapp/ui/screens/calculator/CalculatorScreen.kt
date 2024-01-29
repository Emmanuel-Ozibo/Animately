package com.example.animatelyapp.ui.screens.calculator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.components.FancyPrimaryButton
import com.example.animatelyapp.ui.components.header.ShipmentCalculationHeader
import com.example.animatelyapp.ui.components.header.ShipmentHeaderState
import com.example.animatelyapp.ui.screens.calculator.widget.CategoryWidget
import com.example.animatelyapp.ui.screens.calculator.widget.PackagingWidget
import com.example.animatelyapp.ui.screens.calculator.widget.ShipmentDestinationWidget
import com.example.animatelyapp.ui.theme.dirtyWhite
import com.example.animatelyapp.utils.DummyData
import kotlinx.coroutines.delay

@Composable
fun CalculatorScreen(onBackClick: () -> Unit) {

    var headerStates by remember { mutableStateOf(ShipmentHeaderState.EXPANDED) }
    var showContent by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = "random") {
        delay(100)
        headerStates = ShipmentHeaderState.COLLAPSED
        showContent = true
    }

    Column (modifier = Modifier.background(dirtyWhite)){
        ShipmentCalculationHeader(
            headerState = headerStates,
            onClick = onBackClick
        )


        AnimatedVisibility(visible = showContent,
            enter = fadeIn(animationSpec = tween(durationMillis = 300, easing = LinearEasing))
                    + expandVertically (animationSpec = tween(durationMillis = 500)){ it }
        ) {
            Column {
                ShipmentDestinationWidget(
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )

                PackagingWidget()

                CategoryWidget(
                    categories = DummyData.getCategories()
                )

                FancyPrimaryButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    buttonText = "Calculate") {

                }

            }
        }

    }
}
