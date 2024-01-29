package com.example.animatelyapp.ui.screens.calculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.AnimatedCounterTextView
import com.example.animatelyapp.ui.components.BusinessLogo
import com.example.animatelyapp.ui.components.FancyPrimaryButton
import com.example.animatelyapp.ui.components.header.ShipmentCalculationHeader
import com.example.animatelyapp.ui.components.header.ShipmentHeaderState
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import kotlinx.coroutines.delay

@Composable
fun CalculatorResultScreen(
    modifier: Modifier = Modifier,
    backToHomeClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BusinessLogo()


        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(id = R.drawable.box),
            contentDescription = ""
        )


        Column ( horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "Total Estimated account",
                style = MaterialTheme.typography.headlineMedium
            )

            AnimatedCounterTextView(value = 2000)

            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = "This amount is estimated this will vary if you change your location and weight",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )

            FancyPrimaryButton(
                modifier = Modifier
                    .padding(
                        bottom = 32.dp, start = 16.dp,
                        end = 16.dp
                    )
                    .fillMaxWidth(),
                buttonText = "Back to home"
            ) {
                backToHomeClick()
            }
        }

    }

}


@Preview
@Composable
private fun CalculatorResultScreenPreview() {
    AnimatelyAppTheme {
        CalculatorResultScreen {

        }
    }
}
