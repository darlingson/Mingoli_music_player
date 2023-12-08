package com.codeshinobi.mingoli_music_player.NavScreens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.codeshinobi.mingoli_music_player.ui.theme.Mingoli_music_playerTheme

@Composable
fun NavHomeScreen(navController: NavController) {
    Mingoli_music_playerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            Text(text = "Home Screen")
        }
        }
}