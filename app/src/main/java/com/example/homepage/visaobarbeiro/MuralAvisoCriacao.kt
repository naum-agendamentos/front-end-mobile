import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homepage.R



@Composable
fun Mural() {
    val backgroundImage = painterResource(id = R.drawable.telavisaodobarbeiro)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.logobarbeiro),
            contentDescription = "Login image",
            modifier = Modifier
                .size(60.dp)
                .padding(start = 5.dp)
                .padding(top = 10.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Calendário",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                ),
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 90.dp)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(350.dp)
                    .height(500.dp)
                    .offset(y = -20.dp)
                    .background(
                        color = Color.White.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .border(2.dp, Color.Gray, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    // Conteúdo da caixa
                    Text(
                        text = "Desconto por tempo limitado",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Desconto por tempo limitado no mês de páscoa, 30% de desconto em:",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "• Cortes simples\n• Barba simples\n• Corte feminino simples",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Desconto disponível até dia 30 de abril",
                        fontSize = 16.sp,
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = "Programar:", fontSize = 16.sp)
                            OutlinedTextField(
                                value = "30/04/2023",
                                onValueChange = {},
                                enabled = false
                            )
                        }

                        Column {
                            Text(text = "Status: ", fontSize = 16.sp)
                            var isActive by remember { mutableStateOf(true) }
                            Switch(
                                checked = isActive,
                                onCheckedChange = { isActive = it }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                        ) {
                            Text(text = "CANCELAR", color = Color.White)
                        }
                        Button(
                            onClick = { /* Handle save */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                        ) {
                            Text(text = "SALVAR", color = Color.White)
                        }
                    }
                }
            }

            Text(
                text = "10H00",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            )

            Edicao(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun MuralAviso() {
    Mural()
}
