package com.example.animatelyapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.example.animatelyapp.ui.theme.grey


@Composable
fun FancyDropdown(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes leadingIcon: Int
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = grey
    ) {
        Row(
            modifier = modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = leadingIcon),
                tint = Color.Gray,
                contentDescription = ""
            )

            VerticalDivider()


            Text(
                modifier = Modifier.weight(1f),
                text = title,
                color = Color.Black,
                style = MaterialTheme.typography.titleMedium)

            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                contentDescription = "Open Dropdown",
                tint = Color.Gray
            )

        }
    }
}


@Preview
@Composable
fun FancyDropdownPreview() {
    AnimatelyAppTheme {
        FancyDropdown(
            title = "Box",
            leadingIcon = R.drawable.ic_sender_address
        )
    }
}