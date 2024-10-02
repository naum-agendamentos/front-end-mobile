package com.example.homepage.visaobarbeiro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.homepage.visaobarbeiro.ui.theme.HomepageTheme

class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomepageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Dashboard(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Dashboard(name: String, modifier: Modifier = Modifier) {
    val backgroundImage = painterResource(id = R.drawable.fundo_barbeiro)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row {
                navBarb()
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center // Centraliza o conteúdo
            ) {
                Text(
                    text = "DASHBOARD",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column (modifier = Modifier.padding(10.dp)) {
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            1.dp,
                            Color.White,
                            RoundedCornerShape(5.dp)
                        )
                        .background(colorResource(id = R.color.preto),

                            RoundedCornerShape(12.dp)
                        )) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "LUCRO TOTAL DA BARBEARIA",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.White
                            )
                        )

                        Text(
                            text = "R$210.00",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                color = Color.White
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth() // Faz o Row ocupar toda a largura disponível
                ) {
                    Box(
                        modifier = Modifier
                            .width(150.dp)
                            .border(1.dp, Color.White, RoundedCornerShape(5.dp))
                            .background(colorResource(id = R.color.preto), RoundedCornerShape(12.dp))
                            .padding(10.dp) // Padding interno
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth() // Garante que a coluna ocupe toda a largura da Box
                        ) {
                            Text(
                                text = "MÉDIA DE AVALIAÇÃO",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                    color = Color.White
                                )
                            )
                            Text(
                                text = "0 ★",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                    color = Color.White
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp)) // Espaço entre as Box

                    Box(
                        modifier = Modifier
                            .weight(1f) // Distribui o espaço igualmente entre as Box
                            .border(1.dp, Color.White, RoundedCornerShape(5.dp))
                            .background(colorResource(id = R.color.preto), RoundedCornerShape(12.dp))
                            .padding(10.dp) // Padding interno
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth() // Garante que a coluna ocupe toda a largura da Box
                        ) {
                            Text(
                                text = "TOTAL AGENDAMENTO NO DIA",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                    color = Color.White
                                )
                            )
                            Text(
                                text = "0 - 0% que ontem",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                    color = Color.White
                                )
                            )
                        }
                    }
                }

            }

        }

    }
    IconRow()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview3() {
    HomepageTheme {
        Dashboard("Android")
    }
}