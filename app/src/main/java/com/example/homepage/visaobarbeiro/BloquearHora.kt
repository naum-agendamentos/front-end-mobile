package com.example.homepage.visaobarbeiro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homepage.R
import com.example.homepage.ui.theme.HomepageTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun telaBloqueioDeHora() {
    val backgroundImage = painterResource(id = R.drawable.fundo_barbeiro)
    val horarios = gerarHorarios("08:00", "20:00")
    val coresHoras = remember { mutableStateListOf(*Array(horarios.size) { Color.Transparent }) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        navBarb()
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "BLOQUEAR HORÁRIO",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 90.dp)
            )
            Box(
                modifier = Modifier
                    .height(580.dp)
                    .width(350.dp)
                    .background(
                        color = colorResource(id = R.color.preto),
                        shape = RoundedCornerShape(15.dp)
                    ),
                contentAlignment = Alignment.TopStart
            ) {
                LazyColumn(
                    modifier = Modifier
                        .width(350.dp)
                        .height(430.dp)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Passa a lista de horários diretamente
                    itemsIndexed(horarios) { index, horario ->
                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .padding(vertical = 8.dp)
                                .background(coresHoras[index], shape = RoundedCornerShape(10.dp))
                                .border(color = Color.White, width = 3.dp, shape = RoundedCornerShape(10.dp))
                                .padding(16.dp)
                                .align(Alignment.Center)
                                .clickable {
                                    // Ação ao clicar no Box
                                    coresHoras[index] = if (coresHoras[index] == Color.Transparent) Color.Red else Color.Transparent
                                },
                                contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = horario,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(vertical = 20.dp, horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(160.dp)
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.btn_vermelho), // Cor de fundo do botão
                            contentColor = Color.White   // Cor do texto
                        )
                    )
                        {
                            Text(
                                text = "CANCELAR",
                                style = TextStyle(
                                    fontSize = 16.sp,  // Aumenta o tamanho da fonte
                                    fontWeight = FontWeight.Bold, // Opcional: deixa o texto em negrito
                                    color = Color.White // Cor do texto (opcional)
                                )
                            )
                    }
                    Button(onClick = { /*TODO*/ }, modifier = Modifier
                        .width(160.dp)
                        .height(60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.btn_cadastrar), // Cor de fundo do botão
                            contentColor = Color.White)   // Cor do texto
                        ) {
                        Text(
                            text = "SALVAR",
                            style = TextStyle(
                                fontSize = 16.sp,  // Aumenta o tamanho da fonte
                                fontWeight = FontWeight.Bold, // Opcional: deixa o texto em negrito
                                color = Color.White // Cor do texto (opcional)
                            )
                        )
                    }
                }
            }
        }
    }
}

fun gerarHorarios(inicio: String, fim: String): List<String> {
    val listaHorarios = mutableListOf<String>()
    val formato = SimpleDateFormat("HH:mm", Locale.getDefault())
    val calendario = Calendar.getInstance()

    // Define a hora inicial
    calendario.time = formato.parse(inicio) ?: return listaHorarios
    // Define a hora final
    val horaFinal = formato.parse(fim) ?: return listaHorarios

    // Gera horários de acordo com o intervalo
    while (calendario.time.before(horaFinal)) {
        listaHorarios.add(formato.format(calendario.time))
        calendario.add(Calendar.MINUTE, 30) // Ajuste para 30 minutos
    }
    return listaHorarios
}


@Preview(showBackground = true)
@Composable
fun BloqueioHoraPreview() {
    HomepageTheme {
        telaBloqueioDeHora()
    }
}