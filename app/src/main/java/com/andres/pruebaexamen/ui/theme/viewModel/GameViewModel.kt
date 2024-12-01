package com.andres.pruebaexamen.ui.theme.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.andres.pruebaexamen.ui.theme.state.GameState


class GameViewModel : ViewModel() {
    private var _gameState = mutableStateOf(GameState())
    val gameState: GameState by _gameState

    fun drawCardForPlayer(player: Int) {
        // Actualizamos el estado con las cartas robadas por cada jugador
        val newState = if (player == 1) {
            _gameState.value.copy(
                player1Card = (1..13).random()
            )
        } else {
            _gameState.value.copy(
                player2Card = (1..13).random()
            )
        }
        _gameState.value = newState
        checkGameOver()
    }

    private fun checkGameOver() {
        // Revisar si ambas cartas están robadas
        if (_gameState.value.player1Card != null && _gameState.value.player2Card != null) {
            val winner = when {
                _gameState.value.player1Card == _gameState.value.player2Card -> "Empate"
                _gameState.value.player1Card!! > _gameState.value.player2Card!! -> "Jugador 1 Gana"
                else -> "Jugador 2 Gana"
            }
            _gameState.value = _gameState.value.copy(
                isGameOver = true,
                winner = winner
            )
        }
    }

    fun restartGame() {
        // Reiniciar el estado del juego
        _gameState.value = GameState()
    }
}