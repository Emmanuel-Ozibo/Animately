package com.example.animatelyapp.ui.components.avaliablevehicles

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R


@Composable
fun AvailableVehicle(vehicles: List<ShipmentVehicle>) {

    Column {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Tracking",
            style = MaterialTheme.typography.titleLarge
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            items(vehicles.size) {index ->
                val vehicle = vehicles[index]

                ShipmentTypeComposable(
                    modifier = Modifier.width(200.dp),
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
            iconRes = R.drawable.air_shipment
        ),

        ShipmentVehicle(
            name = "Cargo Freight",
            iconRes = R.drawable.cargo_shipment
        ),

        ShipmentVehicle(
            name = "Truck Freight",
            iconRes = R.drawable.truck_shipment
        )
    )


    AvailableVehicle(vehicles = vehicles)
}

