package com.andres.pruebaexamen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.andres.pruebaexamen.navegation.AppCartaNavHost
import com.andres.pruebaexamen.ui.theme.PruebaExamenTheme
import com.andres.pruebaexamen.ui.theme.viewModel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PruebaExamenTheme {
                //Crear el viewNodel de manera compartida
                val gameViewModel: GameViewModel = viewModel()

                //Pasamos el viewModel al NavHost
                AppCartaNavHost(gameViewModel)
            }
        }
    }
}


