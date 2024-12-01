package com.andres.pruebaexamen.ui.theme.screen

import com.andres.pruebaexamen.ui.theme.viewModel.GameViewModel

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.andres.pruebaexamen.navegation.AppScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    navController: NavController,
    gameViewModel: GameViewModel // ViewModel compartido
) {
    val gameState = gameViewModel.gameState // Obtener el estado del juego desde el ViewModel

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Carta Alta") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) { // Regresar a HomeScreen
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), // Respetar los insets de Scaffold
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Indicadores de las cartas robadas
            Text(
                text = "Jugador 1: ${gameState.player1Card?.toString() ?: "No ha robado aún"}",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { gameViewModel.drawCardForPlayer(1) },
                enabled = gameState.player1Card == null
            ) {
                Text("Jugador 1 roba carta")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Jugador 2: ${gameState.player2Card?.toString() ?: "No ha robado aún"}",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { gameViewModel.drawCardForPlayer(2) },
                enabled = gameState.player2Card == null
            ) {
                Text("Jugador 2 roba carta")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    navController.navigate("${AppScreens.GAMEOVER.name}/${gameState.winner}")
                },
                enabled = gameState.isGameOver
            ) {
                Text("Terminar Partida")
            }
        }
    }
}