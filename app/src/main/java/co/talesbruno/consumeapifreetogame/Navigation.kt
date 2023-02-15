package co.talesbruno.consumeapifreetogame

import android.provider.ContactsContract
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.talesbruno.consumeapifreetogame.ui.home.Home
import co.talesbruno.consumeapifreetogame.ui.home.game.GameDetail
import co.talesbruno.consumeapifreetogame.viewmodel.MainViewModel

@Composable
fun Navigation(
    mainViewModel: MainViewModel
){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            Home(
                mainViewModel = mainViewModel,
                onNavigateToDetailScreen = { gameId ->
                    navController.navigate("detail/$gameId")
                }
            )
        }
        composable("about"){

        }
        composable(
            "detail/{gameId}",
            arguments = listOf(navArgument("gameId") { type = NavType.IntType })
        ){ backStackEntry ->
            val gameId = backStackEntry.arguments?.getInt("gameId")
            requireNotNull(gameId)
            GameDetail(mainViewModel = mainViewModel, gameId = gameId, navController = navController)
        }
    }
}