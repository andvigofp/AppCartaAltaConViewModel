package com.andres.pruebaexamen.ui.theme.screen
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.andres.pruebaexamen.navegation.AppScreens
import com.andres.pruebaexamen.ui.theme.viewModel.GameViewModel


@Composable
fun HomeScreen(
    navController: NavController,  // Se usa para manejar la navegación
    gameViewModel: GameViewModel = viewModel() // ViewModel compartido
) {
    // Reiniciar el estado del juego antes de iniciar una nueva partida
    gameViewModel.restartGame()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mensaje de bienvenida
        Text(
            text = "Bienvenido al juego de Carta Alta",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Descripción
        Text(
            text = "Pulsa en 'Jugar' para comenzar",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para iniciar el juego
        Button(onClick = { navController.navigate(AppScreens.GAME.name) }) {
            Text(text = "Jugar")
        }
    }
}



