package com.ssitcm.jeec.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ssitcm.jeec.R
import com.ssitcm.jeec.viewmodel.UserViewModel
@Composable
fun WelcomeScreen(navController: NavController, userViewModel: UserViewModel) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    val SanFrancisco = FontFamily(
        Font(R.font.sanfranciscodisplaybold, FontWeight.Bold),
        Font(R.font.sanfranciscodisplayregular, FontWeight.Normal),
        Font(R.font.sanfranciscomonobold, FontWeight.Bold, FontStyle.Italic)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Juntas en el ciclo",
            fontFamily = SanFrancisco,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.cetis22),
            contentDescription = "Logo del CETis 22",
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp),
            alignment = Alignment.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de Nombre
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Campo de Edad
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Edad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Botón de registro
        Button(
            onClick = {
                userViewModel.registerUser(
                    name = name,
                    age = age,
                    onSuccess = {
                        navController.navigate("main_screen") {
                            popUpTo("welcome_screen") { inclusive = true }
                        }
                    },
                    onError = { error -> errorMessage = error }
                )
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text("Registrar")
        }

        // Mostrar mensajes de error
        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
