package com.example.animatelyapp.ui.components.avaliablevehicles

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import kotlinx.coroutines.delay


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AvailableVehicleSection(
    modifier: Modifier = Modifier,
    vehicles: List<ShipmentVehicle>
) {
    var transX by remember { mutableFloatStateOf(500f) }


    val floatAnimation by animateFloatAsState(
        targetValue = transX,
        label = "x_animation",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMediumLow
        )
    )

    LaunchedEffect("launch") {
        delay(100)
        transX = 0f
    }

    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Available vehicles",
            style = MaterialTheme.typography.titleLarge
        )

        LazyRow(
            modifier = Modifier.graphicsLayer {
                translationX = floatAnimation
            },
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(vehicles, key = { it.name }) { vehicle ->
                ShipmentTypeComposable(
                    modifier = Modifier
                        .animateItemPlacement()
                        .width(200.dp),
                    shipmentType = vehicle.name,
                    shipmentImage = vehicle.iconRes
                )
            }

        }

    }
}

data class ShipmentVehicle(
    val name: String,
    @DrawableRes val iconRes: Int
)


@Preview
@Composable
fun AvailableVehiclePreview() {
    val vehicles = listOf(
        ShipmentVehicle(
            name = "Air Freight",
            iconRes = R.drawable.cargo_plane
        ),

        ShipmentVehicle(
            name = "Cargo Freight",
            iconRes = R.drawable.cargo_ship
        ),

        ShipmentVehicle(
            name = "Truck Freight",
            iconRes = R.drawable.cargo_truck
        )
    )


    AvailableVehicleSection(vehicles = vehicles)
}

