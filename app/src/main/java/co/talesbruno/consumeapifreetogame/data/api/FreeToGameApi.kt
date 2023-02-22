package co.talesbruno.consumeapifreetogame.data.api

import co.talesbruno.consumeapifreetogame.domain.model.Game
import co.talesbruno.consumeapifreetogame.domain.model.GameDetail
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface FreeToGameApi {

    @GET("games")
    suspend fun findAllGames(): Response<List<Game>>

    @GET("game?")
    suspend fun getGameByID(@Query("id") id: Int): Response<GameDetail>
}