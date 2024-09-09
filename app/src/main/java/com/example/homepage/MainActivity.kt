package com.example.homepage

import Footer
import PasswordChangeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.homepage.visaocliente.Cadastro
import com.example.homepage.visaocliente.Login

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login()
            Cadastro()
            Footer()
            PasswordChangeScreen()
        }
    }
}



