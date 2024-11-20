package com.bootcamp.ejerciciodocekotlin.state

data class IMCState (val genero: String = "Hombre",
                val edad: String = "",
                val peso: String = "",
                val altura: String = "",
                val resultadoIMC: String = "",
    val errorMessage: String = ""

)