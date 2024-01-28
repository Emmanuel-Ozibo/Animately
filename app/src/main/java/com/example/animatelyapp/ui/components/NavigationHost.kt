package com.example.animatelyapp.ui.components

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.animatelyapp.ui.components.bottomnavbar.Destinations
import com.example.animatelyapp.ui.screens.CalculatorResultScreen
import com.example.animatelyapp.ui.screens.CalculatorScreen
import com.example.animatelyapp.ui.screens.SearchReceiptScreen
import com.example.animatelyapp.ui.screens.ShipmentScreen
import com.example.animatelyapp.ui.screens.ShipmentSummaryScreen
import com.example.animatelyapp.utils.Constants

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    rootNavController: NavHostController,
    onDestinationChanged: (Boolean) -> Unit,
) {
    rootNavController.addOnDestinationChangedListener { _, destination, _ ->
        onDestinationChanged(
            destination.route == Destinations.Shipment.route
        )
    }

    NavHost(
        modifier = modifier,
        navController = rootNavController,
        startDestination = "homeNav",
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        navigation(route = "homeNav", startDestination = "shipments_summary") {

            composable(route = "shipments_summary") {
                ShipmentSummaryScreen()
            }
//
//            composable(route = "search_receipt",
//                enterTransition = { fadeIn(animationSpec = tween(durationMillis = Constants.TRANSITION_ANIM_DURATION)) },
//                exitTransition = { fadeOut(animationSpec = tween(durationMillis = Constants.TRANSITION_ANIM_DURATION)) }) {
//                SearchReceiptScreen()
//            }
        }

        navigation(route = "calculateNav", startDestination = "calculator") {
            composable(route = "calculator") {
                CalculatorScreen()
            }

            composable(route = "calculator_result") {
                CalculatorResultScreen()
            }
        }

        composable(route = "shipment") {
            ShipmentScreen()
        }

        composable(route = "profile_screen") {
            ShipmentScreen()
        }
    }
}
