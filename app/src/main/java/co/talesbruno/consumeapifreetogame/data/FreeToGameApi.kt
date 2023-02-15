package co.talesbruno.consumeapifreetogame.data

import co.talesbruno.consumeapifreetogame.model.Game
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface FreeToGameApi {

    @GET("games")
    fun findAllGames(): Call<List<Game>>

    @GET("game?")
    fun getGameByID(@Query("id") id: Int): Call<Game>
}