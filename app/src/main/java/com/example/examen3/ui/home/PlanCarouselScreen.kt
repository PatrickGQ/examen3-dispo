package com.example.examen3.ui.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.examen3.ui.navigation.Routes

@Composable
fun PlanCarouselScreen(
    navController: NavHostController,
    viewModel: PlanCarouselViewModel = hiltViewModel()
) {
    val index = viewModel.index.value
    val plan = viewModel.planes[index]

    val isDark = isSystemInDarkTheme()
    val subtitleColor = if (isDark) Color.White else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Nuestros planes móviles",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = Color(0xFFEF5350),
                fontWeight = FontWeight.Bold
            ),
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 24.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )


        Text(
            text = "La mejor cobertura, increíbles beneficios\ny un compromiso con el planeta.",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = subtitleColor
            ),
            fontSize = 18.sp,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Botones y tarjeta al mismo nivel
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Botón <
            Button(
                onClick = { viewModel.previousPlan() },
                enabled = index > 0,
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEF5350),
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(36.dp)
            ) {
                Text("<", color = Color.White)
            }

            Spacer(modifier = Modifier.width(4.dp))

            // PlanCard centrado
            Box(modifier = Modifier.weight(1f)) {
                PlanCard(
                    plan = plan,
                    onSelectPlan = {
                        navController.navigate(Routes.ENVIAR_SIM)
                    }
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            // Botón >
            Button(
                onClick = { viewModel.nextPlan() },
                enabled = index < viewModel.planes.size - 1,
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEF5350),
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(36.dp)
            ) {
                Text(">", color = Color.White)
            }
        }
    }
}
