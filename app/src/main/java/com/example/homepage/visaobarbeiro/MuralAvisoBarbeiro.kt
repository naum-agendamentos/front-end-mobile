import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.homepage.R

@Composable
fun MuralAvisoBarbeiro() {
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
            contentDescription = stringResource(id = R.string.login_image),
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
                text = stringResource(id = R.string.agendamentos),
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
                    // Adicionando os itens de serviço
                    MuralDeAviso(
                        nome = stringResource(id = R.string.corte_simples),
                        preco = stringResource(id = R.string.preco_corte_simples),
                        duracao = stringResource(id = R.string.duracao_corte_simples),
                        isSelected = true
                    )
                    MuralDeAviso(
                        nome = stringResource(id = R.string.barba_simples),
                        preco = stringResource(id = R.string.preco_barba_simples),
                        duracao = stringResource(id = R.string.duracao_barba_simples),
                        isSelected = true
                    )
                    MuralDeAviso(
                        nome = stringResource(id = R.string.corte_feminino_simples),
                        preco = stringResource(id = R.string.preco_corte_feminino_simples),
                        duracao = stringResource(id = R.string.duracao_corte_feminino_simples),
                        isSelected = false
                    )
                    MuralDeAviso(
                        nome = stringResource(id = R.string.platinado),
                        preco = stringResource(id = R.string.preco_platinado),
                        duracao = stringResource(id = R.string.duracao_platinado),
                        isSelected = false
                    )
                }
            }

            Text(
                text = stringResource(id = R.string.hora_exemplo),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            )

            MuralAvisos(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun MuralDeAviso(
    nome: String,
    preco: String,
    duracao: String,
    isSelected: Boolean
) {
    var checked by remember { mutableStateOf(isSelected) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFCCCCFF), RoundedCornerShape(12.dp))
            .border(2.dp, Color.Black, RoundedCornerShape(12.dp))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(text = nome, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = preco, fontSize = 14.sp)
            Text(text = duracao, fontSize = 14.sp)
        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(if (checked) Color.Blue else Color.White, shape = RoundedCornerShape(4.dp))
                .border(2.dp, Color.Black, shape = RoundedCornerShape(4.dp))
                .clickable { checked = !checked },
            contentAlignment = Alignment.Center
        ) {
            if (checked) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = stringResource(id = R.string.checked),
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun MuralAvisos(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(color = Color.White)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(
                    Color.White,
                    RoundedCornerShape(12.dp)
                )
                .border(2.dp, Color.Gray, RoundedCornerShape(12.dp))
                .zIndex(1f),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = stringResource(id = R.string.home),
                modifier = Modifier.size(40.dp),
                tint = Color.Black
            )
        }

        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.White, RoundedCornerShape(12.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(12.dp))
                .zIndex(1f),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search),
                modifier = Modifier.size(40.dp),
                tint = Color.Black
            )
        }

        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.White, RoundedCornerShape(12.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(12.dp))
                .zIndex(1f),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = stringResource(id = R.string.notifications),
                modifier = Modifier.size(40.dp),
                tint = Color.Black
            )
        }

        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.White, RoundedCornerShape(12.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(12.dp))
                .zIndex(1f),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = stringResource(id = R.string.profile),
                modifier = Modifier.size(40.dp),
                tint = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun MuralBarbeiro() {
    MuralAvisoBarbeiro()
}
