package co.talesbruno.consumeapifreetogame.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.talesbruno.consumeapifreetogame.domain.model.Game
import co.talesbruno.consumeapifreetogame.domain.model.GameDetail
import co.talesbruno.consumeapifreetogame.domain.useCase.GetAllGamesUseCase
import co.talesbruno.consumeapifreetogame.domain.useCase.GetGameByIdUseCase
import co.talesbruno.consumeapifreetogame.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val getGameByIdUseCase: GetGameByIdUseCase
) : ViewModel() {

    private val _detailState = MutableStateFlow<Result<GameDetail>>(Result.Loading())
    val detailState: StateFlow<Result<GameDetail>> = _detailState

    fun getAllGames(id: Int) {
        viewModelScope.launch {
            _detailState.value = getGameByIdUseCase(id)
        }
    }

}