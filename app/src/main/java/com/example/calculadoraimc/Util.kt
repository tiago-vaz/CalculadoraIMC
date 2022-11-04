package com.example.calculadoraimc


internal fun getImcResult(pesoTxt: String, alturaTxt: String): IMCResult {

    // Validação para verificar se os campos de texto estiverem vazios.
    // A falta desse tratamento irá causar crash no app
    if (pesoTxt == "" || alturaTxt == "") {
        return IMCResult(Result.BLANK)
    }

    // Conversão dos valores recebidos como texto para float, para poder realizar o cálculo
    val peso = pesoTxt.toFloat()
    val altura = alturaTxt.toFloat()

    // Cálculo do IMC
    val imc = peso / (altura * altura)

    // Retorna a descrição do nível de acordo com o resultado do cálculo
    if (imc < 16){
        return IMCResult(Result.MAGREZA_III)
    } else if (imc < 17){
        return IMCResult(Result.MAGREZA_II)
    } else if (imc < 18.5){
        return IMCResult(Result.MAGREZA_I)
    } else if (imc < 25){
        return IMCResult(Result.OK)
    } else if (imc < 30){
        return IMCResult(Result.SOBREPESO)
    } else if (imc < 35){
        return IMCResult(Result.OBESIDADE_I)
    } else if (imc < 40){
        return IMCResult(Result.OBESIDADE_II)
    } else {
        return IMCResult(Result.OBESIDADE_III)
    }
}

data class IMCResult(val result: Result)
enum class Result(val label: String) {
    MAGREZA_III("Magreza Severa"),
    MAGREZA_II("Magreza moderada"),
    MAGREZA_I("Magreza leve"),
    OK("Saudável"),
    SOBREPESO("Sobrepeso"),
    OBESIDADE_I("Obesidade Grau I"),
    OBESIDADE_II("Obesidade Grau II (severa)"),
    OBESIDADE_III("Obesidade Grau III (mórbida)"),
    BLANK("Insira valores de peso e altura corretamente, seu animal!")
}