package co.talesbruno.consumeapifreetogame.data

import javax.inject.Inject

class GamesRepository @Inject constructor(private val freeToGameApi: FreeToGameApi) {

    fun getAllGames() = freeToGameApi.findAllGames()

    fun getGameById(id: Int) = freeToGameApi.getGameByID(id)
}