package com.codeshinobi.mingoli_music_player

sealed class Screens(val route : String) {
    object Home : Screens("home_screen")
    object Search : Screens("library_screen")
    object Profile : Screens("settings_screen")
}