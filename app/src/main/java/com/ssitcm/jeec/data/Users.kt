package com.ssitcm.jeec.data

data class Users(
    val age: String,
    val nombre: String? = null // Agregado como nullable, será llenado desde la respuesta
)
