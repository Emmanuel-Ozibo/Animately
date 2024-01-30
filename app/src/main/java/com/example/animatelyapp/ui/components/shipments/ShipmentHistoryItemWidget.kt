package com.example.animatelyapp.ui.components.shipments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.FancyStatusBadge
import com.example.animatelyapp.ui.components.Status
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.primaryLight
import com.example.animatelyapp.utils.DummyData


@Composable
fun ShipmentHistoryItemWidget(
    modifier: Modifier = Modifier,
    shipmentHistory: ShipmentHistory
) {

    Card (
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ){
        Column(modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            FancyStatusBadge(status = shipmentHistory.status)

            Spacer(modifier = Modifier.padding(bottom = 8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column (modifier = Modifier.weight(3f)){
                    Text(
                        text = shipmentHistory.title,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.padding(bottom = 8.dp))

                    Text(
                        text = shipmentHistory.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }

                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .weight(0.6f)
                        .aspectRatio(1f),
                    painter = painterResource(id = R.drawable.box),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.padding(bottom = 24.dp))

            Row {
                Text(
                    text = shipmentHistory.price,
                    color = primaryLight,
                    style = MaterialTheme.typography.labelLarge
                )

                Spacer(modifier = Modifier.padding(end = 16.dp))

                Text(
                    text = shipmentHistory.date,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }

}


@Preview
@Composable
private fun ShipmentHistoryItemWidgetPreview() {
    AnimatelyAppTheme {
        ShipmentHistoryItemWidget(
            shipmentHistory = DummyData.getShipmentHistory()
        )
    }
}


data class ShipmentHistory(
    val status: Status,
    val title: String,
    val description: String,
    val price: String,
    val date: String
)