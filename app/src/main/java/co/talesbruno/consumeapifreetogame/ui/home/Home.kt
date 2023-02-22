package co.talesbruno.consumeapifreetogame.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import co.talesbruno.consumeapifreetogame.ui.home.game.GameItem
import co.talesbruno.consumeapifreetogame.ui.home.menu.DrawerContent
import co.talesbruno.consumeapifreetogame.ui.home.menu.DrawerHeader
import co.talesbruno.consumeapifreetogame.ui.home.menu.MenuItem
import co.talesbruno.consumeapifreetogame.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun Home(
    homeViewModel: HomeViewModel,
    onNavigateToDetailScreen: (Int) -> Unit,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
){
    val games by homeViewModel.gameSate.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Home")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerHeader()
            DrawerContent(items = listOf(
                MenuItem(
                    id = "home",
                    title = "Home",
                    contentDescription = "Go to home screen",
                    icon = Icons.Default.Home
                ),
                MenuItem(
                    id = "about",
                    title = "Sobre",
                    contentDescription = "Go to about screen",
                    icon = Icons.Default.Info
                ),
            ))
        }
    ) {
        when (games){
            is co.talesbruno.consumeapifreetogame.domain.util.Result.Loading -> Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
            is co.talesbruno.consumeapifreetogame.domain.util.Result.Success -> LazyColumn(
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                games.data?.let { gameList ->
                    items(
                        items = gameList,
                        itemContent = {
                            GameItem(game = it, onNavigateToDetailScreen = onNavigateToDetailScreen)
                        }
                    )
                }
            }
            is co.talesbruno.consumeapifreetogame.domain.util.Result.Error -> Column() {
                scope.launch{
                    games.message?.let {
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

