package com.example.animatelyapp.ui.components.tracking

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.lightGreen
import com.example.animatelyapp.ui.theme.lightOrange
import com.example.animatelyapp.ui.theme.orange


@Composable
fun TrackingSection(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = "Tracking",
            style = MaterialTheme.typography.titleLarge
        )

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            ShipmentNumber(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                title = "Shipment Number",
                shipmentNumber = "NEJKJHJDK3333232443",
                iconRes = R.drawable.ic_fork_lift
            )

            Divider(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
                thickness = 1.dp,
                color = Color.Gray.copy(alpha = 0.2f)
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                IconColumn(
                    backgroundColor = lightOrange,
                    iconDrawableRes = R.drawable.ic_send_package,
                    iconTint = Color.Unspecified,
                    title = "Sender",
                    description = "Atlanta, 50943"
                )

                IconColumn(
                    backgroundColor = lightOrange,
                    iconDrawableRes = R.drawable.ic_send_package,
                    iconTint = Color.Unspecified,
                    title = "Time",
                    showIcon = false,
                    description = "2 days - 3 days"
                )
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                IconColumn(
                    backgroundColor = lightGreen,
                    iconDrawableRes = R.drawable.ic_receive_package,
                    iconTint = Color.Unspecified,
                    title = "Receive",
                    description = "Chicago, 50943"
                )

                IconColumn(
                    backgroundColor = lightOrange,
                    iconDrawableRes = R.drawable.ic_receive_package,
                    iconTint = Color.Unspecified,
                    title = "Time",
                    showIcon = false,
                    description = "2 days - 3 days"
                )
            }

            Divider(
                modifier = Modifier.padding(top = 8.dp),
                thickness = 1.dp,
                color = Color.Gray.copy(alpha = 0.2f)
            )

            Surface (modifier = Modifier.clickable {  }){
                Row (
                    modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "",
                        tint = orange
                        )
                    Text(
                        text = "Add Stop",
                        style = MaterialTheme.typography.titleMedium,
                        color = orange)
                }
            }
        }
    }

}



@Preview
@Composable
fun TrackingSectionPreview() {
    AnimatelyAppTheme {
        TrackingSection()
    }
}