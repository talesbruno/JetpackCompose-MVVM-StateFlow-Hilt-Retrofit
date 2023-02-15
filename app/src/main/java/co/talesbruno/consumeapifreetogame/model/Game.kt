package co.talesbruno.consumeapifreetogame.model

import android.net.Uri
import retrofit2.http.Url

data class Game(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String
)
