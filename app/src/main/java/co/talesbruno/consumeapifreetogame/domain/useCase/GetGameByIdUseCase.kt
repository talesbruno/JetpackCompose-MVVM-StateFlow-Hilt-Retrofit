package co.talesbruno.consumeapifreetogame.domain.useCase

import co.talesbruno.consumeapifreetogame.domain.repository.GamesRepository


class GetGameByIdUseCase(private val gamesRepository: GamesRepository) {
    suspend operator fun invoke(id: Int) = gamesRepository.getGameById(id)
}