package com.example.animatelyapp.ui.screens.shipmenthistory

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.components.headers.ShipmentHistoryHeader
import com.example.animatelyapp.ui.components.headers.ShipmentHistoryHeaderState
import com.example.animatelyapp.ui.screens.shipmenthistory.widget.ShipmentHistoryWidget
import com.example.animatelyapp.utils.DummyData
import kotlinx.coroutines.delay

@Composable
fun ShipmentHistoryScreen(onBackClicked: () -> Unit) {

    var headerState by remember { mutableStateOf(ShipmentHistoryHeaderState.START) }
    var showHistories by remember { mutableStateOf(false) }

    LaunchedEffect("shipmentHistory") {
        delay(300)
        showHistories = true
        headerState = ShipmentHistoryHeaderState.FINAL
    }


    Column {
        ShipmentHistoryHeader(
            onBackClick = onBackClicked, headerState = headerState,
            filters = DummyData.getFilterOptions()
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))


        AnimatedVisibility(visible = showHistories,
            enter = fadeIn(animationSpec = tween(durationMillis = 300))
                    + slideInVertically(animationSpec = tween(durationMillis = 400)) { it * 2 }
        ) {
            ShipmentHistoryWidget(
                modifier = Modifier.padding(16.dp),
                shipmentHistories = DummyData.getShipmentHistories()
            )
        }

    }
}
