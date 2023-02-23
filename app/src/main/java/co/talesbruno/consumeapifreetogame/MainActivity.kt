package co.talesbruno.consumeapifreetogame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import co.talesbruno.consumeapifreetogame.presentation.ui.theme.ConsumeApiFreeToGameTheme
import co.talesbruno.consumeapifreetogame.presentation.viewmodel.GameDetailViewModel
import co.talesbruno.consumeapifreetogame.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homeViewModel: HomeViewModel by viewModels()
        val gameDetailViewModel: GameDetailViewModel by viewModels()

        setContent {
            ConsumeApiFreeToGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation(homeViewModel = homeViewModel, gameDetailViewModel = gameDetailViewModel)
                }
            }
        }
    }
}
