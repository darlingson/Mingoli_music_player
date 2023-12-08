package com.codeshinobi.mingoli_music_player

sealed class Screens(val route : String) {
    object Home : Screens("home_screen")
    object Library : Screens("library_screen")
    object Settings : Screens("settings_screen")
}