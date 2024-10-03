package com.example.homepage.visaocliente.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.homepage.R

@Composable
fun FundoTela(content: @Composable () -> Unit){
    Image(
        painter = painterResource(id = R.drawable.fundo_cliente),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column  {
        Header()
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.91f),
            contentAlignment = Alignment.Center){
            content()
        }
        Navigation()
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FundoTelaPreview(){
    FundoTela{
        MeuPerfil()
    }
}