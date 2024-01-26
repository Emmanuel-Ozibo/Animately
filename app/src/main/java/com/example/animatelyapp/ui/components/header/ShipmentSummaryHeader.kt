package com.example.animatelyapp.ui.components.header


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.CopyIconBg
import com.example.animatelyapp.ui.theme.HeaderBg
import com.example.animatelyapp.ui.theme.Orange
import com.example.animatelyapp.ui.theme.Purple40


@Composable
fun ShipmentSummaryHeader(
    modifier: Modifier = Modifier,
    onSearchBoxClicked: () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = HeaderBg
    ) {
        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 8.dp)) {
            ProfileSummarySection(
                modifier = Modifier.padding(bottom = 8.dp)
            )
            SearchBarSection(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .clickable { onSearchBoxClicked() }
            )
        }
    }

}


@Composable
fun ProfileSummarySection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularAvatar(modifier = Modifier.size(50.dp))


        Column(modifier = Modifier.padding(start = 16.dp)) {
            IconText(
                text = "Your Location",
                textColor = Color.White,
                spacing = 8.dp,
                iconPosition = IconPosition.START,
                iconRes = R.drawable.ic_location
            )

            Spacer(modifier = Modifier.padding(top = 4.dp))

            IconText(
                text = "Emmanuel Ozibo",
                textColor = Color.White,
                spacing = 8.dp,
                iconPosition = IconPosition.END,
                iconRes = R.drawable.ic_arrow_down
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        BackgroundIcon(
            modifier = Modifier.size(50.dp),
            backgroundColor = Color.White,
            iconTint = Color.Black,
            iconDrawableRes = R.drawable.ic_notification,
            iconPadding = 12.dp
        )
    }
}


@Composable
fun SearchBarSection(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(50.dp),
        color = Color.White
    ) {

        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Shipments"
            )

            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                text = "Enter the receipt number",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.weight(1f))

            BackgroundIcon(
                modifier = Modifier.padding(vertical = 8.dp),
                backgroundColor = CopyIconBg,
                iconTint = Color.White,
                iconDrawableRes = R.drawable.ic_link
            )
        }
    }
}


@Preview
@Composable
fun ShipmentSummaryHeaderPreview() {
    AnimatelyAppTheme {
        ShipmentSummaryHeader(
            onSearchBoxClicked = {}
        )
    }

}