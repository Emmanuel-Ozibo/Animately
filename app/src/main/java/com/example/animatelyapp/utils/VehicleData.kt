package com.example.animatelyapp.utils

import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.avaliablevehicles.ShipmentVehicle

object VehicleData {

    fun getAvailableVehicles(): List<ShipmentVehicle> =
        listOf(
            ShipmentVehicle(
                name = "Air Freight",
                iconRes = R.drawable.ic_location
            ),

            ShipmentVehicle(
                name = "Cargo Freight",
                iconRes = R.drawable.ic_location
            ),

            ShipmentVehicle(
                name = "Truck Freight",
                iconRes = R.drawable.ic_location
            )
        )

}