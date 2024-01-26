package com.example.animatelyapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.components.header.ShipmentSummaryHeader
import kotlinx.coroutines.delay


@Composable
fun ShipmentSummaryScreen() {

    var isHeaderSectionVisible by remember {
        mutableStateOf(false)
    }

    val screenDensity = LocalDensity.current

    LaunchedEffect(key1 = isHeaderSectionVisible,) {
        delay(300L)
        isHeaderSectionVisible = true
    }


    Column(verticalArrangement = Arrangement.Top) {
        AnimatedVisibility(visible = isHeaderSectionVisible) {
            ShipmentSummaryHeader(
                onSearchBoxClicked = {}
            )
        }
    }
}