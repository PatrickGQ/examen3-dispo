package com.example.examen3.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.examen3.ui.navigation.Routes

@Composable
fun PlanCarouselScreen(
    navController: NavHostController,
    viewModel: PlanCarouselViewModel = hiltViewModel()
) {
    val plan = viewModel.planes[viewModel.index.value]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Nuestros planes móviles",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { viewModel.previousPlan() },
                enabled = viewModel.index.value > 0
            ) {
                Text("<")
            }

            Button(
                onClick = { viewModel.nextPlan() },
                enabled = viewModel.index.value < viewModel.planes.size - 1
            ) {
                Text(">")
            }
        }

        PlanCard(
            plan = plan,
            onSelectPlan = {
                navController.navigate(Routes.ENVIAR_SIM)
            }
        )
    }
}
