package co.talesbruno.consumeapifreetogame.data.repository

import co.talesbruno.consumeapifreetogame.data.api.FreeToGameApi
import co.talesbruno.consumeapifreetogame.domain.model.Game
import co.talesbruno.consumeapifreetogame.domain.model.GameDetail
import co.talesbruno.consumeapifreetogame.domain.util.Result
import retrofit2.Response
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val freeToGameApi: FreeToGameApi
) : co.talesbruno.consumeapifreetogame.domain.repository.GamesRepository {

    override suspend fun getAllGames(): Result<List<Game>> {
        val response = freeToGameApi.findAllGames()
        if (response.isSuccessful) {
            response.body()?.let {
                return Result.Success(it)
            }
        }
        return Result.Error(response.message())
    }

    override suspend fun getGameById(id: Int): Result<GameDetail> {
        val response = freeToGameApi.getGameByID(id)
        if (response.isSuccessful) {
            response.body()?.let {
                return Result.Success(it)
            }
        }
        return Result.Error(response.message())
    }

}