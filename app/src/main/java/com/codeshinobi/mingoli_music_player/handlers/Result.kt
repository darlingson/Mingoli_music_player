package com.codeshinobi.mingoli_music_player.handlers

/**
 * A generic class that holds a value or an exception.
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Loading<out T>(val data: T?) : Result<Nothing>()
    data class Error(val exception: Exception) : Result<Nothing>()
}