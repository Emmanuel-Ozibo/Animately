package com.example.animatelyapp.ui.components.headers

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.components.FancyScrollableSelection
import com.example.animatelyapp.ui.components.Item
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.primaryLight
import com.example.animatelyapp.utils.DummyData

@Composable
fun ShipmentHistoryHeader(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    headerState: ShipmentHistoryHeaderState,
    filters: List<Item>,
) {
    var filterOptions: List<Item> by remember { mutableStateOf(filters) }

    val transition = updateTransition(targetState = headerState, label = "transition")

    val iconTranslationX by transition.animateFloat(
        label = "iconTranslationX",
        transitionSpec = { tween(durationMillis = 400) },
    ) { state ->
        when (state) {
            ShipmentHistoryHeaderState.START -> -100f
            ShipmentHistoryHeaderState.FINAL -> 0f
        }
    }

    val titleTranslationY by transition.animateFloat(
        label = "titleTranslationY",
        transitionSpec = { tween(durationMillis = 400) },
    ) { state ->
        when (state) {
            ShipmentHistoryHeaderState.START -> -100f
            ShipmentHistoryHeaderState.FINAL -> 0f
        }
    }

    val alphaAnim by transition.animateFloat(
        label = "alphaAnim",
        transitionSpec = { tween(durationMillis = 400) },
    ) { state ->
        when (state) {
            ShipmentHistoryHeaderState.START -> 0f
            ShipmentHistoryHeaderState.FINAL -> 1f
        }
    }

    val filtersTranslationXAnim by transition.animateFloat(
        label = "filtersTranslationXAnim",
        transitionSpec = { tween(durationMillis = 400) },
    ) { state ->
        when (state) {
            ShipmentHistoryHeaderState.START -> 500f
            ShipmentHistoryHeaderState.FINAL -> 0f
        }
    }

    val filtersTranslationYAnim by transition.animateFloat(
        label = "filtersTranslationYAnim",
        transitionSpec = { tween(durationMillis = 400) },
    ) { state ->
        when (state) {
            ShipmentHistoryHeaderState.START -> -500f
            ShipmentHistoryHeaderState.FINAL -> 0f
        }
    }

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = primaryLight,
    ) {
        Column {
            Row(
                modifier = Modifier.padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier =
                        Modifier
                            .size(40.dp)
                            .clickable { onBackClick() }
                            .graphicsLayer {
                                translationX = iconTranslationX
                                alpha = alphaAnim
                            },
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = "Go Back",
                    tint = Color.White,
                )

                Text(
                    modifier =
                        Modifier
                            .weight(1f)
                            .graphicsLayer {
                                alpha = alphaAnim
                                translationY = titleTranslationY
                            },
                    text = "Shipment History",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                )

                Spacer(
                    modifier = Modifier.size(40.dp),
                )
            }

            FancyScrollableSelection(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .graphicsLayer {
                            translationX = filtersTranslationXAnim
                            translationY = filtersTranslationYAnim
                            alpha = alphaAnim
                        },
                options = filterOptions,
                onItemSelected = {
                    val newList =
                        filterOptions.map { item ->
                            if (item == it) item.copy(isSelected = true) else item.copy(isSelected = false)
                        }

                    filterOptions = newList
                },
            )
        }
    }
}

enum class ShipmentHistoryHeaderState {
    START,
    FINAL,
}

@Preview
@Composable
fun ShipmentHistoryHeaderPreview() {
    AnimatelyAppTheme {
        ShipmentHistoryHeader(
            headerState = ShipmentHistoryHeaderState.START,
            onBackClick = {},
            filters = DummyData.getFilterOptions(),
        )
    }
}
