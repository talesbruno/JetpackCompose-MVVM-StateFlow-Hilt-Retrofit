package co.talesbruno.consumeapifreetogame.domain.useCase

import co.talesbruno.consumeapifreetogame.domain.repository.GamesRepository
import javax.inject.Inject

class GetAllGamesUseCase @Inject constructor(private val gamesRepository: GamesRepository) {
    suspend operator fun invoke() = gamesRepository.getAllGames()
}