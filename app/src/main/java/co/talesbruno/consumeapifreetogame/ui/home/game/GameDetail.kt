package co.talesbruno.consumeapifreetogame.ui.home.game

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.talesbruno.consumeapifreetogame.model.GameDetail
import co.talesbruno.consumeapifreetogame.viewmodel.MainViewModel
import coil.compose.rememberAsyncImagePainter

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GameDetail(
    mainViewModel: MainViewModel,
    gameId: Int,
    navController: NavController,
) {
    fun launch() {
        mainViewModel.getGameById(gameId)
    }
    launch()

    val gameDetail by mainViewModel.game.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = gameDetail.title) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) {
        Column() {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .height(250.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(gameDetail.thumbnail),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()

                )
            }
            Column(modifier = Modifier
                .padding(10.dp)
                ) {
                Text(text = gameDetail.short_description)
            }

        }
    }
}