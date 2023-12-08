package com.codeshinobi.mingoli_music_player

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
){
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = Screens.Home.route
            ),
            BottomNavigationItem(
                label = "Library",
                icon = Icons.Default.List,
                route = Screens.Library.route
            ),
            BottomNavigationItem(
                label = "Settings",
                icon = Icons.Filled.Settings,
                route = Screens.Settings.route
            )
        )
    }
}
