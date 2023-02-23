package co.talesbruno.consumeapifreetogame.presentation.ui.home.game

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.talesbruno.consumeapifreetogame.presentation.viewmodel.GameDetailViewModel
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun GameDetail(
    gameDetailViewModel: GameDetailViewModel,
    gameId: Int,
    navController: NavController,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    fun launch() {
        gameDetailViewModel.getAllGames(gameId)
    }
    launch()

    val gameDetail by gameDetailViewModel.detailState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Game info") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) {
        when (gameDetail){
            is co.talesbruno.consumeapifreetogame.domain.util.Result.Loading -> Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
            is co.talesbruno.consumeapifreetogame.domain.util.Result.Success -> Column() {
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(250.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(gameDetail.data?.thumbnail),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()

                    )
                }
                Column(modifier = Modifier
                    .padding(10.dp)
                ) {
                    gameDetail.data?.let { it1 -> Text(text = it1.title) }
                    gameDetail.data?.let { it1 -> Text(text = it1.short_description) }
                }

            }
            is co.talesbruno.consumeapifreetogame.domain.util.Result.Error -> Column() {
                scope.launch{
                    gameDetail.message?.let {
                        scaffoldState.snackbarHostState.showSnackbar(
                            it,
                            "Ok",
                            SnackbarDuration.Long
                        )
                    }
                }
            }
        }
    }
}