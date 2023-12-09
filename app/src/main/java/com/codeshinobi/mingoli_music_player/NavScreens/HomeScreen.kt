package com.codeshinobi.mingoli_music_player.NavScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.codeshinobi.mingoli_music_player.ui.theme.Mingoli_music_playerTheme

@Composable
fun NavHomeScreen(navController: NavController) {
    Mingoli_music_playerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ){
            HomeScreenSetUp()
        }
        }
}
@Composable
fun HomeScreenSetUp(){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        MostPlayedSongs()
        MostPlayedArtist()
        MostPlayedGenres()
    }
}
@Composable
fun MostPlayedSongs(){
    Text(
        text = "Most Played Songs",
        fontSize = 20.sp
        )
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {
        repeat(10) {
            SongCard(title = "song $it", artist ="Artist $it" )
        }
    }
}
@Composable
fun SongCard(title:String,artist:String){
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .size(width = 100.dp, height = 150.dp)
            .padding(6.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
        Text(
            text = artist,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun MostPlayedGenres(){
    Text(
        text = "Most Played Genres",
        fontSize = 20.sp
    )
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {
        repeat(10) {
            GenreCard(name = "genre $it")
        }
    }
}
@Composable
fun GenreCard(name: String){
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .size(width = 100.dp, height = 150.dp)
            .padding(6.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun MostPlayedArtist(){
    Text(
        text = "Most Played Artists",
        fontSize = 20.sp
    )
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {
        repeat(10) {
            ArtistCard(name = "Artist $it")
        }
    }
}
@Composable
fun ArtistCard(name:String){
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .size(width = 100.dp, height = 150.dp)
            .padding(6.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreenSetUp()
}
