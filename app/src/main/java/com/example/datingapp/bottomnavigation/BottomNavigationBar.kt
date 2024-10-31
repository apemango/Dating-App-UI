package com.example.datingapp.bottomnavigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.datingapp.Screens
import com.example.datingapp.screens.ChatScreen
import com.example.datingapp.screens.HomeScreen
import com.example.datingapp.screens.ProfileScreen
import com.example.datingapp.screens.SearchScreen


@Composable
fun BottomNavigationBar() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(containerColor = Color.White, modifier = Modifier.height(100.dp)) {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
                    NavigationBarItem(
                        colors = NavigationBarItemColors(
                            selectedIconColor = Color.DarkGray,
                            selectedTextColor = Color.White,
                            unselectedIconColor = Color.LightGray, // Add unselected icon color
                            unselectedTextColor = Color.Gray,      // Add unselected text color
                            disabledIconColor = Color.LightGray,    // Existing disabled icon color
                            disabledTextColor = Color.DarkGray,     // Add disabled text color
                            selectedIndicatorColor = Color.Transparent      // Add selected indicator color
                        ),
                        selected = navigationItem.route == currentDestination?.route,
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Chat.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(Screens.Home.route) {
                HomeScreen(
                    navController
                )
            }
            composable(Screens.Search.route) {
                SearchScreen(
                    navController
                )
            }
            composable(Screens.Chat.route) {
                ChatScreen(
                    navController
                )
            }

            composable(Screens.Profile.route) {
                ProfileScreen(
                    navController
                )
            }
        }
    }
}