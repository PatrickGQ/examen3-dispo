package com.example.examen3.ui.home

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Plan
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.geometry.Offset
import com.example.examen3.R

@Composable
fun PlanCard(plan: Plan, onSelectPlan: () -> Unit) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Nombre del plan
            Text(
                text = plan.nombre,
                color = Color(0xFFEF5350),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Precios
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 20.dp)) {
                Text(
                    text = "Antes ",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Box {
                    Text(
                        text = "$${plan.precioAntes}",
                        fontSize = 18.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )

                    // Línea roja simulada sobre el texto
                    Canvas(modifier = Modifier
                        .matchParentSize()
                        .padding()) {
                        drawLine(
                            color = Color(0xFFB71C1C),
                            start = Offset(0f, size.height / 2),
                            end = Offset(size.width, size.height / 2),
                            strokeWidth = 5f
                        )
                    }
                }
                Text(
                    text = " /mes",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Ahora ",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = "$${plan.precioAhora}",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black
                )
                Text(
                    text = " /mes",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            Text(
                text = "${plan.datosGB}GB",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de beneficios
            plan.beneficios.forEach { beneficio ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "✓",
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = beneficio,
                        fontSize = 14.sp,
                        color = Color(0xFFBDBDBD)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Redes sociales
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                val icons = listOf(
                    R.drawable.ic_whatsapp_button,
                    R.drawable.ic_facebook,
                    R.drawable.ic_x,
                    R.drawable.ic_instagram,
                    R.drawable.ic_snapchat,
                    R.drawable.ic_telegram
                )
                icons.forEach { iconRes ->
                    Box(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Surface(
                            shape = RoundedCornerShape(50),
                            color = Color.Black
                        ) {
                            Icon(
                                painter = painterResource(id = iconRes),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .padding(6.dp)
                                    .size(20.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                // Botón principal
                Button(
                    onClick = onSelectPlan,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF5350)),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text(
                        text = "Quiero este plan",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Icono de WhatsApp superpuesto
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (-12).dp, y = -20.dp)
                        .clickable {
                            val message = "Hola, UCB mobile, preciso su ayuda"
                            val phoneNumber = "59172726315"
                            val url = "https://wa.me/$phoneNumber?text=${Uri.encode(message)}"
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            try {
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                ) {
                    Surface(
                        shape = RoundedCornerShape(50),
                        color = Color(0xFF25D366),
                        shadowElevation = 4.dp,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_whatsapp_button),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .padding(10.dp)
                                .size(28.dp)
                        )
                    }
                }
            }
        }
    }
}