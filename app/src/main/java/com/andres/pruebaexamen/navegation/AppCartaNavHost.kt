package com.andres.pruebaexamen.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.andres.pruebaexamen.ui.theme.screen.GameOverScreen
import com.andres.pruebaexamen.ui.theme.screen.GameScreen
import com.andres.pruebaexamen.ui.theme.screen.HomeScreen
import com.andres.pruebaexamen.ui.theme.viewModel.GameViewModel


@Composable
fun AppCartaNavHost(gameViewModel: GameViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.HOME.name) {
        composable(AppScreens.HOME.name) {
           HomeScreen(navController = navController)
        }

        composable(AppScreens.GAME.name) {
            GameScreen(
                navController = navController,
                gameViewModel = gameViewModel
            )
        }

        composable(
            route = "${AppScreens.GAMEOVER.name}/{winner}",
            arguments = listOf(navArgument("winner") { type = NavType.StringType })
        ) { backStackEntry ->
            val winner = backStackEntry.arguments?.getString("winner") ?: "Empate"
            GameOverScreen(
                winner = winner,
                navController = navController,
                gameViewModel = gameViewModel
            )
        }
    }
}