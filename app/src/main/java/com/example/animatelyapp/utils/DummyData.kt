package com.example.animatelyapp.utils

import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.Shipment
import com.example.animatelyapp.ui.components.StaggeredItem
import com.example.animatelyapp.ui.components.avaliablevehicles.ShipmentVehicle


object DummyData {

    fun getAvailableVehicles(): List<ShipmentVehicle> =
        listOf(
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


    fun getStaggeredItems(): List<StaggeredItem<String>> = listOf(
        StaggeredItem(value = "Documents", selected = false, title = "Document"),
        StaggeredItem(value = "Glass", selected = false, title = "Glass"),
        StaggeredItem(value = "Liquid", selected = false, title = "Liquid"),
        StaggeredItem(value = "Food", selected = false, title = "Food"),
        StaggeredItem(value = "Electronic", selected = false, title = "Electronic"),
        StaggeredItem(value = "Products", selected = false, title = "Products"),
        StaggeredItem(value = "Others", selected = false, title = "Others")
    )


}