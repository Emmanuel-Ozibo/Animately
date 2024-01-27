package com.example.animatelyapp.ui.components.tracking

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.header.BackgroundIcon
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.lightOrange


@Composable
fun IconColumn(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    @DrawableRes iconDrawableRes: Int,
    iconTint: Color,
    showIcon: Boolean = true,
    title: String,
    description: String
) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

        if(showIcon) {
            BackgroundIcon(
                modifier = Modifier.size(50.dp),
                backgroundColor = backgroundColor,
                iconDrawableRes = iconDrawableRes,
                iconTint = iconTint
            )
        }

        Column(modifier = Modifier.padding(start = if (showIcon) 16.dp else 0.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = description,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }

}



@Preview
@Composable
fun IconColumnPreview() {
    AnimatelyAppTheme {
        IconColumn(
            backgroundColor = lightOrange,
            iconDrawableRes = R.drawable.ic_send_package,
            iconTint = Color.Unspecified,
            title = "Sender",
            description = "Atlanta, 50943"
        )
    }
}


@Preview
@Composable
fun IconColumnShowPreview() {
    AnimatelyAppTheme {
        IconColumn(
            backgroundColor = lightOrange,
            iconDrawableRes = R.drawable.ic_send_package,
            iconTint = Color.Unspecified,
            showIcon = false,
            title = "Sender",
            description = "Atlanta, 50943"
        )
    }
}


