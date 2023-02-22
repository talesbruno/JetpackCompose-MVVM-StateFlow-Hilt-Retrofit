package co.talesbruno.consumeapifreetogame.domain.repository

import co.talesbruno.consumeapifreetogame.domain.model.Game
import co.talesbruno.consumeapifreetogame.domain.model.GameDetail
import co.talesbruno.consumeapifreetogame.domain.util.Result

interface GamesRepository {
    suspend fun getAllGames(): Result<List<Game>>
    suspend fun getGameById(id: Int): Result<GameDetail>
}