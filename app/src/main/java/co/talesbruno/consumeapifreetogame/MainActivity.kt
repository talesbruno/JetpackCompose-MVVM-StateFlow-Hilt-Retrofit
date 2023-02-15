package co.talesbruno.consumeapifreetogame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import co.talesbruno.consumeapifreetogame.ui.home.Home
import co.talesbruno.consumeapifreetogame.ui.theme.ConsumeApiFreeToGameTheme
import co.talesbruno.consumeapifreetogame.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel: MainViewModel by viewModels()

        setContent {
            ConsumeApiFreeToGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation(mainViewModel = mainViewModel)
                }
            }
        }
    }
}
