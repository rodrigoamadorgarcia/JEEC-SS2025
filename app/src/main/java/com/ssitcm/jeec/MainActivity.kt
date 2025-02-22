package com.ssitcm.jeec

/*   Diseñado y programado por Rodrigo Alberto Amador García y Erick Jhoan Hernández Delgado  */
/*   "Juntas en el ciclo" es una aplicación para brindar información sobre la menstruación.   */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.ssitcm.jeec.navigation.NavGraph
import com.ssitcm.jeec.ui.theme.JEECTheme
import com.ssitcm.jeec.viewmodel.UserViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            JEECTheme  {
                val navController = rememberNavController()
                val userViewModel: UserViewModel = viewModel()

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                NavGraph(
                    navController = navController,
                    userViewModel = userViewModel
                )
            }
        }
    }
}
