package com.example.calculadoraimc

import org.junit.Assert.*

import org.junit.Test

class UtilTest {

    @Test // Verificar que se a mensagem de sobrepeso é retornada quando peso = 90 e altura = 1.80
    fun testGetImcResult_90_180_sobrepeso() {
        val result = getImcResult("90", "1.80")

        assertEquals(result.result, Result.SOBREPESO)
    }

    @Test // Verificar que caso o peso não for informado, mensagem de aviso é exibida
    fun testGetImcResult_embranco_aviso() {
        val result = getImcResult("", "1.80")

        assertEquals(result.result, Result.BLANK)
    }
}