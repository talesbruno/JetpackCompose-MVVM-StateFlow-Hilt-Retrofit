package co.talesbruno.consumeapifreetogame.domain.useCase

import co.talesbruno.consumeapifreetogame.domain.repository.GamesRepository

class GetAllGamesUseCase(private val gamesRepository: GamesRepository) {
    suspend operator fun invoke() = gamesRepository.getAllGames()
}