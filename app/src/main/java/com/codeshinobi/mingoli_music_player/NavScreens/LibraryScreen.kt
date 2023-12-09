package com.codeshinobi.mingoli_music_player.NavScreens

import android.annotation.SuppressLint
import android.content.ContentUris
import android.content.Context
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.codeshinobi.mingoli_music_player.Models.MusicCardModel
import com.codeshinobi.mingoli_music_player.Models.convertMili
//import com.codeshinobi.mingoli_music_player.Models.getAlbumArt
import com.codeshinobi.mingoli_music_player.ui.theme.Mingoli_music_playerTheme

@Composable
fun NavLibraryScreen(navController: NavController) {
    Mingoli_music_playerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            MusicList()
        }
    }
}
@SuppressLint("Recycle")
fun Context.musicList(): MutableList<MusicCardModel> {
    val list = mutableListOf<MusicCardModel>()
    val collection = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
    } else {
        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
    }
    val projection = arrayOf(
        MediaStore.Audio.Media._ID,
        MediaStore.Audio.Media.DISPLAY_NAME,
        MediaStore.Audio.Media.DURATION,
        MediaStore.Audio.Media.TITLE,
        MediaStore.Audio.Media.ALBUM_ID,
        MediaStore.Audio.Media.ARTIST
    )
    val selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0"
    val sortOrder = "${MediaStore.Audio.Media.DISPLAY_NAME} ASC"
    val query = this.contentResolver.query(
        collection,
        projection,
        selection,
        null,
        sortOrder
    )
    query?.use { cursor ->
        val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
        val durationColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)
        val titleColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
        val artistColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
        val albumIdColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID)
        while (cursor.moveToNext()) {
            val id = cursor.getLong(idColumn)
            val duration = cursor.getInt(durationColumn)
            val title = cursor.getString(titleColumn)
            val artist = cursor.getString(artistColumn)
            val albumId = cursor.getLong(albumIdColumn)
            val contentUri: Uri = ContentUris.withAppendedId(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                id
            )
            val durationString = convertMili(duration)
            list.add(MusicCardModel(contentUri, id,  title, artist, durationString))
        }
    }
    return list
}
@Composable
fun MusicList() {
    val context = LocalContext.current
    val list = context.musicList()
    LazyColumn {
        items(list.size) { music ->
            MusicCard(list[music])
        }
    }
}
@Composable
fun MusicCard(music: MusicCardModel) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.weight(4f) // takes up 80% width
        ) {
            Text(
                text = music.songTitle,
                fontSize = 20.sp
            )
            Text(
                text = music.artist,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Text(
            text = music.duration,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f) // takes up 20% width
        )
    }
}