package co.talesbruno.consumeapifreetogame.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.talesbruno.consumeapifreetogame.domain.model.Game
import co.talesbruno.consumeapifreetogame.domain.useCase.GetAllGamesUseCase
import co.talesbruno.consumeapifreetogame.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllGamesUseCase: GetAllGamesUseCase
) : ViewModel() {

    private val _gamesState = MutableStateFlow<Result<List<Game>>>(Result.Loading())
    val gameSate: StateFlow<Result<List<Game>>> = _gamesState

    init {
        getAllGames()
    }

    private fun getAllGames() {
        viewModelScope.launch {
            _gamesState.value = getAllGamesUseCase()
        }
    }

}