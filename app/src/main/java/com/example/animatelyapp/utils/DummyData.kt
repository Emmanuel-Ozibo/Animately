package com.example.animatelyapp.utils

import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.Shipment
import com.example.animatelyapp.ui.components.avaliablevehicles.ShipmentVehicle
import com.example.animatelyapp.ui.screens.calculator.widget.Category

object DummyData {

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


    fun getShipments(): List<Shipment> =
        listOf(
            Shipment(
                title = "Summer Linen Jacket",
                detail = "#NFHJHDHD3675678489 \u2022 Barcelona \u2192 Paris"
            ),

            Shipment(
                title = "Tarpared Jeans",
                detail = "#NFHJHDHD3675678489 \u2022 Barcelona \u2192 Nigeria"
            ),

            Shipment(
                title = "Macbook Pro M2",
                detail = "#NFHJHDHD3675678489 \u2022 Paris \u2192 London"
            ),

            Shipment(
                title = "Office Desk",
                detail = "#NFHJHDHD3675678489 \u2022 London \u2192 Dubai"
            )
        )

    fun getCategories(): List<Category> =
        listOf(
            Category("Documents"),
            Category("Glass"),
            Category("Liquid"),
            Category("Food"),
            Category("Electronic"),
            Category("Products"),
            Category("Others"),
        )


}