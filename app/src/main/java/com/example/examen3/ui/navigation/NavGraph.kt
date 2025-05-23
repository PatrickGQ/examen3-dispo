package com.example.examen3.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.examen3.ui.home.PlanCarouselScreen
import com.example.examen3.ui.sim.EnviarSimScreen

object Routes {
    const val PLANES = "planes"
    const val ENVIAR_SIM = "enviar_sim"
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.PLANES) {
        composable(Routes.PLANES) {
            PlanCarouselScreen(navController)
        }
        composable(Routes.ENVIAR_SIM) {
            EnviarSimScreen(navController)
        }
    }
}
