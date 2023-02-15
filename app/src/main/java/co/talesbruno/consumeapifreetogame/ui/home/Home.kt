package co.talesbruno.consumeapifreetogame.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.talesbruno.consumeapifreetogame.ui.home.game.GameItem
import co.talesbruno.consumeapifreetogame.ui.home.menu.DrawerContent
import co.talesbruno.consumeapifreetogame.ui.home.menu.DrawerHeader
import co.talesbruno.consumeapifreetogame.ui.home.menu.MenuItem
import co.talesbruno.consumeapifreetogame.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(
    mainViewModel: MainViewModel,
    onNavigateToDetailScreen: (Int) -> Unit,
){

    val games by mainViewModel.games.collectAsState()

    val errorMessage by mainViewModel.errorMessage.collectAsState()

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

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
        if (games.isNotEmpty()){
            LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
                items(games) { game ->
                    GameItem(game = game, onNavigateToDetailScreen = onNavigateToDetailScreen)
                }
            }
        }else{
            Text(text = errorMessage, color = Color.Blue)
        }
    }
}