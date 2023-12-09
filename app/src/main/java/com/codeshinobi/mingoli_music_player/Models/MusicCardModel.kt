package com.codeshinobi.mingoli_music_player.Models

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import android.net.Uri
import com.codeshinobi.mingoli_music_player.R
import java.util.concurrent.TimeUnit
import android.util.Base64

data class MusicCardModel(
    val contentUri: Uri,
    val songId: Long,
    val songTitle: String,
    val artist: String,
    val duration: String
)

//fun getAlbumArt(context: Context, uri: Uri): Bitmap {
//    val mmr = MediaMetadataRetriever()
//    var bitmap: Bitmap? = null
//    try {
//        mmr.setDataSource(context, uri)
//        val data = mmr.embeddedPicture
//        if (data != null) {
//            // Decode the Base64-encoded string into a byte array
//            val decodedImageBytes = Base64.decode(data, Base64.DEFAULT)
//            // Decode the byte array into a Bitmap
//            bitmap = BitmapFactory.decodeByteArray(decodedImageBytes, 0, decodedImageBytes.size)
//        }
//    } catch (e: Exception) {
//        // Handle or log the exception
//    }
//    return bitmap ?: BitmapFactory.decodeResource(context.resources, R.drawable.note)
//}

fun convertMili(milliSeconds: Int): String {
    val hours = TimeUnit.MILLISECONDS.toHours(milliSeconds.toLong())
    val minutes = TimeUnit.MILLISECONDS.toMinutes(milliSeconds.toLong()) - TimeUnit.HOURS.toMinutes(hours)
    val seconds = TimeUnit.MILLISECONDS.toSeconds(milliSeconds.toLong()) - TimeUnit.MINUTES.toSeconds(minutes)
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}