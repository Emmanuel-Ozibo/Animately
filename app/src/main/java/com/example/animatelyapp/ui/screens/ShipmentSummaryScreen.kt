package com.example.animatelyapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.avaliablevehicles.AvailableVehicleSection
import com.example.animatelyapp.ui.components.avaliablevehicles.ShipmentVehicle
import com.example.animatelyapp.ui.components.header.ShipmentSummaryHeader
import com.example.animatelyapp.ui.components.tracking.TrackingSection
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.dirtyWhite
import com.example.animatelyapp.utils.VehicleData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ShipmentSummaryScreen() {

    var isHeaderSectionVisible by remember { mutableStateOf(false) }

    val alphaAnimation =  remember { Animatable(initialValue = 0f) }
    val translationAnimation = remember { Animatable(-500f) }

    val screenDensity = LocalDensity.current


    LaunchedEffect(key1 = isHeaderSectionVisible) {
        isHeaderSectionVisible = true
        launch {
            alphaAnimation.animateTo(1f,
                animationSpec = tween(durationMillis = 900, delayMillis = 300)
            )
        }

        launch {
            translationAnimation.animateTo(0f,
                animationSpec = tween(durationMillis = 300, delayMillis = 300)
            )
        }

    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(color = dirtyWhite),
        verticalArrangement = Arrangement.Top
    ) {
        AnimatedVisibility(visible = isHeaderSectionVisible,
            enter = slideInVertically (
                animationSpec = tween(delayMillis = 300, durationMillis = 300)){ -it }) {
            ShipmentSummaryHeader(
                onSearchBoxClicked = {},
            )
        }

        TrackingSection(
            modifier = Modifier
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)
                .graphicsLayer {
                    alpha = alphaAnimation.value
                    translationY = -translationAnimation.value
                }
        )


        AnimatedVisibility(visible = isHeaderSectionVisible,) {
            AvailableVehicleSection(
                modifier = Modifier.padding(top = 32.dp, start = 16.dp, end = 16.dp)
                    .graphicsLayer {
                        alpha = alphaAnimation.value
                        translationY = -translationAnimation.value
                    },
                vehicles = VehicleData.getAvailableVehicles()
            )
        }

    }
}


@Preview
@Composable
fun ShipmentSummaryScreenPreview() {
    AnimatelyAppTheme {
        ShipmentSummaryScreen()
    }
}
