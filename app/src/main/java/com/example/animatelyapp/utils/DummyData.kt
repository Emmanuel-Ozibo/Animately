package com.example.animatelyapp.utils

import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.Item
import com.example.animatelyapp.ui.components.Shipment
import com.example.animatelyapp.ui.components.StaggeredItem
import com.example.animatelyapp.ui.components.Status
import com.example.animatelyapp.ui.components.avaliablevehicles.ShipmentVehicle
import com.example.animatelyapp.ui.components.shipments.ShipmentHistory


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

    fun getShipmentHistory() = ShipmentHistory(
        status = Status.IN_PROGRESS,
        title = "Arriving today",
        description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
        price = "\$2000 USD",
        date = "Sept 20, 2023"
    )


    fun getShipmentHistories(): List<ShipmentHistory> = listOf(
        ShipmentHistory(
            status = Status.IN_PROGRESS,
            title = "Arriving today1",
            description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
            price = "\$2000 USD",
            date = "Sept 20, 2023"
        ),

        ShipmentHistory(
            status = Status.LOADING,
            title = "Arriving today2",
            description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
            price = "\$2000 USD",
            date = "Sept 20, 2023"
        ),

        ShipmentHistory(
            status = Status.PENDING,
            title = "Arriving today3",
            description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
            price = "\$2000 USD",
            date = "Sept 20, 2023"
        ),

        ShipmentHistory(
            status = Status.IN_PROGRESS,
            title = "Arriving today4",
            description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
            price = "\$2000 USD",
            date = "Sept 20, 2023"
        ),

        ShipmentHistory(
            status = Status.IN_PROGRESS,
            title = "Arriving today5",
            description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
            price = "\$2000 USD",
            date = "Sept 20, 2023"
        ),

        ShipmentHistory(
            status = Status.PENDING,
            title = "Arriving today6",
            description = "Your delivery, #NJHFDDLFJ49389788792 from Atlanta is arriving today",
            price = "\$2000 USD",
            date = "Sept 20, 2023"
        )
    )

    fun getFilterOptions(): List<Item> = listOf(
        Item(
            title = "All",
            count = "30",
            isSelected = true
        ),

        Item(
            title = "In Progress",
            count = "10",
            isSelected = false
        ),

        Item(
            title = "Pending",
            count = "10",
            isSelected = false
        ),

        Item(
            title = "Loading",
            count = "10",
            isSelected = false
        )
    )

}