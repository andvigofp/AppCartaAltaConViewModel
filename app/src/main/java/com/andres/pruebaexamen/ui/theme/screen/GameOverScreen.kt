package com.andres.pruebaexamen.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.andres.pruebaexamen.navegation.AppScreens
import com.andres.pruebaexamen.ui.theme.viewModel.GameViewModel

@Composable
fun GameOverScreen(
    winner: String,
    navController: NavController,
    gameViewModel: GameViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Resultado: $winner", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(64.dp))
        Button(onClick = {
            gameViewModel.restartGame() // Reiniciar el juego
            navController.popBackStack(AppScreens.HOME.name, inclusive = false)
        }) {
            Text("Reiniciar Juego")
        }
    }
}
