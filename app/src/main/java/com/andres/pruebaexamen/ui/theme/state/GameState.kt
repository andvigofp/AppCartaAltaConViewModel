package com.andres.pruebaexamen.ui.theme.state

data class GameState(
    val player1Card: Int? = null,
    val player2Card: Int? = null,
    val isGameOver: Boolean = false,
    val winner: String = "Empate"
)
