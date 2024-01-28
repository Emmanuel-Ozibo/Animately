package com.example.animatelyapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.tracking.IconColumn
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.lightOrange
import com.example.animatelyapp.utils.DummyData


@Composable
fun Shipments(
    modifier: Modifier = Modifier,
    shipments: List<Shipment> = DummyData.getShipments()) {
    Card (
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ){
        LazyColumn (
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Top) {

            items(shipments.size) {index ->
                val shipment = shipments[index]

                IconColumn(
                    backgroundColor = lightOrange,
                    iconDrawableRes = R.drawable.ic_send_package,
                    iconTint = Color.Unspecified,
                    showIcon = false,
                    title = shipment.title,
                    description = shipment.detail,
                    titleTextStyle = MaterialTheme.typography.titleMedium,
                    descriptionTextStyle = MaterialTheme.typography.bodyMedium
                )

                if (index < DummyData.getShipments().size) {
                    Divider(
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = Color.Gray.copy(alpha = 0.15f),
                    )
                }
            }

        }
    }

}



@Preview
@Composable
fun ShipmentsPreview() {
    AnimatelyAppTheme {
        Shipments()
    }
}


data class Shipment(
    val title: String,
    val detail: String
)