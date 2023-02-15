package co.talesbruno.consumeapifreetogame.viewmodel

import androidx.lifecycle.ViewModel
import co.talesbruno.consumeapifreetogame.data.GamesRepository
import co.talesbruno.consumeapifreetogame.model.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val gamesRepository: GamesRepository) : ViewModel() {

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    private val _games = MutableStateFlow(emptyList<Game>())
    val games: StateFlow<List<Game>> = _games

    private val emptyGame = Game(0,"vazio", "nao encontrado", "vazio")
    private val _game = MutableStateFlow(emptyGame)
    val game: StateFlow<Game> = _game

    init {
        getAllGames()
    }

    private fun getAllGames(){
        val request = gamesRepository.getAllGames()
        request.enqueue(object : Callback<List<Game>>{
            override fun onResponse(call: Call<List<Game>>, response: Response<List<Game>>) {
                if (response.isSuccessful){
                    _games.value = response.body() ?: emptyList()
                }else{
                    _errorMessage.value = response.errorBody().toString()
                }
            }

            override fun onFailure(call: Call<List<Game>>, t: Throwable) {
                _errorMessage.value = t.message.toString()
            }

        })
    }

    fun getGameById(id: Int){
        val request = gamesRepository.getGameById(id)
        request.enqueue(object  : Callback<Game>{
            override fun onResponse(call: Call<Game>, response: Response<Game>) {
                if (response.isSuccessful){
                    _game.value = response.body() ?: emptyGame
                }else{
                    _errorMessage.value = response.errorBody().toString()
                }
            }

            override fun onFailure(call: Call<Game>, t: Throwable) {
                _errorMessage.value = t.message.toString()
            }

        })
    }
}