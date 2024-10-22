package com.example.homepage.visaobarbeiro

import BarbeiroEntity
import SemanaEntity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homepage.R
import com.example.homepage.ui.theme.HomepageTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun telaBloqueioDeDia(barbeiro: BarbeiroEntity) {
    val backgroundImage = painterResource(id = R.drawable.fundo_barbeiro)
    val diasDaSemana = listOf("Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado")
    val coresDias = remember {
        mutableStateListOf(
            if (!barbeiro.semana.domingo) Color.Red else Color.Transparent,
            if (!barbeiro.semana.segunda) Color.Red else Color.Transparent,
            if (!barbeiro.semana.terca) Color.Red else Color.Transparent,
            if (!barbeiro.semana.quarta) Color.Red else Color.Transparent,
            if (!barbeiro.semana.quinta) Color.Red else Color.Transparent,
            if (!barbeiro.semana.sexta) Color.Red else Color.Transparent,
            if (!barbeiro.semana.sabado) Color.Red else Color.Transparent
        )
    }


    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val coroutineScope = rememberCoroutineScope()

    val barbeiroService = retrofit.create(ApiBarbeiro::class.java)

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
                text = stringResource(id = R.string.bloquear_dia),
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
                    itemsIndexed(diasDaSemana) { index, dia ->
                        Box(
                            modifier = Modifier
                                .width(170.dp)
                                .padding(vertical = 8.dp)
                                .background(coresDias[index], shape = RoundedCornerShape(10.dp))
                                .border(color = Color.White, width = 3.dp, shape = RoundedCornerShape(10.dp))
                                .padding(16.dp)
                                .align(Alignment.Center)
                                .clickable {
                                    // Alterna a cor entre transparente (disponível) e vermelho (bloqueado)
                                    coresDias[index] = if (coresDias[index] == Color.Transparent) {
                                        Color.Red
                                    } else {
                                        Color.Transparent
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = dia,
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
                    Button(onClick = { /* Ação de Cancelar */ },
                        modifier = Modifier
                            .width(160.dp)
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.btn_vermelho),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "CANCELAR",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                    }

                    // Botão de Salvar
                    Button(onClick = {
                        // Cria a entidade SemanaEntity baseada nos dias selecionados
                        val semana = SemanaEntity(
                            domingo = coresDias[0] == Color.Transparent,
                            segunda = coresDias[1] == Color.Transparent,
                            terca = coresDias[2] == Color.Transparent,
                            quarta = coresDias[3] == Color.Transparent,
                            quinta = coresDias[4] == Color.Transparent,
                            sexta = coresDias[5] == Color.Transparent,
                            sabado = coresDias[6] == Color.Transparent
                        )
                        coroutineScope.launch {
                            try {
                                barbeiroService.putBarbeiros(barbeiro.id, semana)
                            } catch (e: Exception) {
                                // Trate o erro aqui, exiba uma mensagem ou log
                            }
                        }
                    },
                        modifier = Modifier
                            .width(160.dp)
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.btn_cadastrar),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "SALVAR",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BloqueioDiaPreview() {
    HomepageTheme {
        telaBloqueioDeDia(BarbeiroEntity(1, "Bryan", "bryan.com", "1198875454", "meninin fei", "foto feia muito feia", SemanaEntity(false, false, true, false, true, false, true)))
    }
}