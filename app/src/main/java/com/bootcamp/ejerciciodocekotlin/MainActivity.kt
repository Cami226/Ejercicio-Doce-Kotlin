package com.bootcamp.ejerciciodocekotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bootcamp.ejerciciodocekotlin.ui.theme.EjercicioDoceKotlinTheme
import com.bootcamp.ejerciciodocekotlin.view.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjercicioDoceKotlinTheme {
                HomeView()
            }
        }
    }
}

