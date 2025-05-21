package com.example.data.repository

import com.example.domain.model.Plan
import javax.inject.Inject
import javax.inject.Singleton

interface PlanRepository {
    fun getPlanes(): List<Plan>
}

@Singleton
class FakePlanRepository @Inject constructor() : PlanRepository {
    override fun getPlanes(): List<Plan> {
        return listOf(
            Plan(
                nombre = "Plan FLEX 5",
                precioAntes = 270,
                precioAhora = 199,
                datosGB = 5,
                beneficios = listOf(
                    "Llamadas y SMS ilimitados",
                    "Hotspot. Comparte tus datos",
                    "Redes Sociales ilimitadas incluidas",
                    "Arma tu plan con más apps ilimitadas",
                    "CO2 Negativo"
                )
            ),
            Plan(
                nombre = "Plan FLEX 8",
                precioAntes = 370,
                precioAhora = 299,
                datosGB = 8,
                beneficios = listOf(
                    "Llamadas y SMS ilimitados",
                    "Hotspot. Comparte tus datos",
                    "Redes Sociales ilimitadas incluidas",
                    "Arma tu plan con más apps ilimitadas",
                    "CO2 Negativo"
                )
            ),
            Plan(
                nombre = "Plan FLEX 10",
                precioAntes = 470,
                precioAhora = 399,
                datosGB = 10,
                beneficios = listOf(
                    "Llamadas y SMS ilimitados",
                    "Hotspot. Comparte tus datos",
                    "Redes Sociales ilimitadas incluidas",
                    "Arma tu plan con más apps ilimitadas",
                    "CO2 Negativo"
                )
            )
        )
    }
}
