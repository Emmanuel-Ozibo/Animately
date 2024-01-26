package com.example.animatelyapp.ui.components.bottomnavbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun AppBottomNavigation(
    navController: NavController,
    onDestinationChanged: (Boolean) -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val screens = listOf(
        Destinations.HomeScreen, Destinations.Calculate,
        Destinations.Shipment, Destinations.Profile
    )

    NavigationBar {
        for (screen in screens) {
            NavigationBarItem(
                selected = screen.route == currentRoute,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    onDestinationChanged(screen == Destinations.Shipment)
                },
                icon = {
                    Icon(imageVector = screen.icon, contentDescription = "")
                },
                label = {
                    Text(text = screen.title)
                }
            )
        }
    }
}


@Preview
@Composable
fun AppBottomNavigationPreview() {
    AppBottomNavigation(
        navController = rememberNavController(),
        onDestinationChanged = {}
    )
}


sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object HomeScreen : Destinations(
        route = "homeNav",
        title = "Home",
        icon = Icons.Outlined.Home
    )

    data object Calculate : Destinations(
        route = "calculateNav",
        title = "Calculate",
        icon = Icons.Outlined.DateRange
    )

    data object Shipment : Destinations(
        route = "shipment",
        title = "Shipment",
        icon = Icons.Outlined.Refresh
    )

    data object Profile : Destinations(
        route = "profile_screen",
        title = "Profile",
        icon = Icons.Outlined.Person
    )
}