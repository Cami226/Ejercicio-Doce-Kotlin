package com.bootcamp.ejerciciodocekotlin.viewmodel


import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import com.bootcamp.ejerciciodocekotlin.state.IMCState


class CalcularViewModel: ViewModel() {

    var state = mutableStateOf(IMCState())
        private set


    fun onGeneroSelected(genero: String) {
        state.value = state.value.copy(genero = genero)
    }

    fun onEdadChanged(edad: String) {
        state.value = state.value.copy(edad = edad)
    }

    fun onPesoChanged(peso: String) {
        state.value = state.value.copy(peso = peso)
    }

    fun onAlturaChanged(altura: String) {
        state.value = state.value.copy(altura = altura)
    }

    fun calcularIMC() {
        val edadNum = state.value.edad.toIntOrNull()
        val pesoNum = state.value.peso.toFloatOrNull()
        val alturaNum = state.value.altura.toFloatOrNull()?.div(100) // Convertimos cm a m


        // Verificamos si alguno de los campos es nulo o no válido
        //  if (edadNum == null || edadNum <= 0 || pesoNum == null || pesoNum <= 0 || alturaNum == null || alturaNum <= 0) {
        // Establecemos un mensaje de error más específico
        //    errorMessage.value = when {
        //      pesoNum == null -> "El peso debe ser un número válido."
        //        alturaNum == null -> "La altura debe ser un número válido."
        //      edadNum == null -> "La edad debe ser un número válido."
        ////      alturaNum <= 0 -> "La altura debe ser mayor que cero."
        //    pesoNum <= 0 -> "El peso debe ser mayor que cero."
        //      edadNum <= 0 -> "La edad debe ser mayor que cero."
        //      else -> "Datos inválidos."


        when {
            edadNum == null || edadNum <= 0 -> {
                state.value = state.value.copy(
                    errorMessage = "Por favor, ingresa una edad válida (mayor que 0)."

                )
            }

            pesoNum == null || pesoNum <= 0 -> {
                state.value = state.value.copy(
                    errorMessage = "Por favor, ingresa un peso válido (mayor que 0)."

                )
            }

            alturaNum == null || alturaNum <= 0 -> {
                state.value = state.value.copy(
                    errorMessage = "Por favor, ingresa una altura válida (mayor que 0)."
                )
            }

            else -> {
                val imc = pesoNum / (alturaNum * alturaNum)
                val resultado = "%.1f".format(imc)
                state.value = state.value.copy(
                    resultadoIMC = resultado,
                    errorMessage = "" // Limpiar el mensaje de error
                )
            }

        }
    }

    fun clearErrorMessage() {
        state.value = state.value.copy(errorMessage = "")
    }
}

         //  state.value = state.value.copy(resultadoIMC = "") // Limpiar el IMC hasta que se tenga un resultado válido
           // return



        // Si los datos son válidos, calculamos el IMC
        // val imc = pesoNum / (alturaNum * alturaNum)
        // val resultado = "%.1f".format(imc) // Formatear a un decimal

        // errorMessage.value = "" // Limpiar el mensaje de error
        // state.value = state.value.copy(resultadoIMC = resultado)


