package co.talesbruno.consumeapifreetogame

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.talesbruno.consumeapifreetogame.presentation.ui.home.Home
import co.talesbruno.consumeapifreetogame.presentation.ui.home.game.GameDetail
import co.talesbruno.consumeapifreetogame.presentation.viewmodel.GameDetailViewModel
import co.talesbruno.consumeapifreetogame.presentation.viewmodel.HomeViewModel

@Composable
fun Navigation(
    homeViewModel: HomeViewModel,
    gameDetailViewModel: GameDetailViewModel
) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Home(
                homeViewModel = homeViewModel,
                onNavigateToDetailScreen = { gameId ->
                    navController.navigate("detail/$gameId")
                },
                scope = scope,
                scaffoldState = scaffoldState
            )
        }
        composable("about") {

        }
        composable(
            "detail/{gameId}",
            arguments = listOf(navArgument("gameId") { type = NavType.IntType })
        ) { backStackEntry ->
            val gameId = backStackEntry.arguments?.getInt("gameId")
            requireNotNull(gameId)
            GameDetail(
                gameDetailViewModel = gameDetailViewModel,
                gameId = gameId,
                navController = navController,
                scope = scope,
                scaffoldState = scaffoldState
            )
        }
    }
}