package com.example.examen3.ui.home

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.examen3.R

@Composable
fun PlanCard(plan: Plan) {
    val context = LocalContext.current

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(plan.nombre, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "$${plan.precioAntes}",
                    style = MaterialTheme.typography.bodyLarge.copy(textDecoration = TextDecoration.LineThrough),
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "$${plan.precioAhora}",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Text("${plan.datosGB} GB", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(vertical = 8.dp))

            plan.beneficios.forEach { beneficio ->
                Text("✓ $beneficio")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = { /* Acción para seleccionar plan */ }, modifier = Modifier.fillMaxWidth()) {
                Text("Quiero este plan")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    /*val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/59172726315"))
                    context.startActivity(intent)*/
                    val message = "Hola, UCB mobile, preciso su ayuda"
                    val phoneNumber = "59172726315" // sin el '+'
                    val url = "https://wa.me/$phoneNumber?text=${Uri.encode(message)}"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                    try {
                        context.startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF25D366))
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_whatsapp), contentDescription = "WhatsApp")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Contáctanos por WhatsApp")
            }
        }
    }
}