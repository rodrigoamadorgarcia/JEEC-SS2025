package com.ssitcm.jeec.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ssitcm.jeec.R
import com.ssitcm.jeec.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    userViewModel: UserViewModel // Se pasa el ViewModel para obtener el nombre del usuario
) {
    val SanFrancisco = FontFamily(
        Font(R.font.sanfranciscodisplaybold, FontWeight.Bold),
        Font(R.font.sanfranciscodisplayregular, FontWeight.Normal),
        Font(R.font.sanfranciscomonobold, FontWeight.Bold)
    )

    // Se observa el nombre del usuario desde el ViewModel
    val userName by userViewModel.userName.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Bienvenido a la App",
                            fontFamily = SanFrancisco,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF00695C) // Color personalizado para el top bar
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF00695C),
                contentColor = Color.White
            ) {
                // Primer ícono con texto
                IconButton(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cetis22),
                            contentDescription = "Inicio",
                            tint = Color.White
                        )
                        Text(
                            "Inicio",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White
                        )
                    }
                }

                Spacer(Modifier.width(16.dp))

                // Segundo ícono con texto
                IconButton(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cetis22),
                            contentDescription = "Perfil",
                            tint = Color.White
                        )
                        Text(
                            "Perfil",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Mostrar el nombre del usuario
            Text(
                text = "¡Hola, $userName!",
                fontFamily = SanFrancisco,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = Color(0xFF00695C)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Logo",
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("nextScreen") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Continuar")
            }
        }
    }
}
