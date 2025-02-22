package com.ssitcm.jeec.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/usuarios/registrar")
    fun registrarUsuario(@Body user: Users): Call<Users>
}
