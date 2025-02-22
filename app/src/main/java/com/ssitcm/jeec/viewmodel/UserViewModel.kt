package com.ssitcm.jeec.viewmodel

import androidx.lifecycle.ViewModel
import com.ssitcm.jeec.data.RetrofitClient
import com.ssitcm.jeec.data.Users
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class UserViewModel : ViewModel() {
    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName

    // Función para actualizar el nombre del usuario
    fun setUserName(name: String) {
        _userName.value = name
    }

    fun registerUser(
        name: String,
        age: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val user = Users(nombre = name, age = age)

        RetrofitClient.instance.registrarUsuario(user).enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    // Actualizar el nombre del usuario después del registro
                    setUserName(name)
                    onSuccess()
                } else {
                    val errorMessage = "Error al registrar el usuario: ${response.code()} - ${response.message()}"
                    onError(errorMessage)
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                val errorMessage = "Error de conexión: ${t.message}"
                onError(errorMessage)
            }
        })
    }
}
