package com.example.domain.model

data class Plan(
    val nombre: String,
    val precioAntes: Int,
    val precioAhora: Int,
    val datosGB: Int,
    val beneficios: List<String>
)