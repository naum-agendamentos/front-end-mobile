package com.example.homepage.visaocliente.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MeuPerfil() {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color.White.copy(alpha = 0.5f),
        shadowElevation = 3.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.7f)
                .background(color = Color.White.copy(0.5f))
                .border(1.dp, Color.Black, RoundedCornerShape(12.dp))
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f)
            ){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.3f)
                ){
                    Text(
                        text = "MEU PERFIL",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp)

                    ){

//                    Row (
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(40.dp)
//                    ){
                        OutlinedTextField(
                            value = "Teste",
                            onValueChange = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                        )
//                        Text(
//                            text = "Nome: Diego Hessel",
//                            fontSize = 20.sp,
//                            fontWeight = FontWeight.Bold
//                        )
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                    ){
                        Text(
                            text = "E-mail: diego.hessel@gmail.com",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                    ){
                        Text(
                            text = "Telefone: (11) 98756-1234",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.8f),
                    contentAlignment = Alignment.BottomCenter
                ){
                    Surface(
                        shape = RoundedCornerShape(5.dp)
                    ){
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .width(155.dp)
                                .height(40.dp)
                                .background(color = Color.Blue),

                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Blue,
                                contentColor = Color.White
                            )
                        ) {
                            Row {
                                Icon(
                                    imageVector = Icons.Filled.Edit,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(30.dp)
                                        .fillMaxHeight()

                                )
                                Text(
                                    fontSize = 20.sp,
                                    text = "EDITAR",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }

    }


}

//@Preview(showSystemUi = true)
//@Composable
//fun MeuPerfilPreview() {
//    MeuPerfil()
//}

@Preview(showSystemUi = true)
@Composable
fun MeuPerfilTelaPreview() {
    FundoTela {
        MeuPerfil()
    }
}