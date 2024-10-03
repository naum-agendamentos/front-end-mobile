package com.example.homepage.visaocliente.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.homepage.visaocliente.componentes.FundoTela
import com.example.homepage.visaocliente.componentes.Header
import com.example.homepage.visaocliente.componentes.MeuPerfil
import com.example.homepage.visaocliente.componentes.Navigation
@Preview(showSystemUi = true)
@Composable
fun MeuPerfilTela() {
    Column {
        Header()
        FundoTela {
            MeuPerfil()
        }
        Navigation()
    }
}

