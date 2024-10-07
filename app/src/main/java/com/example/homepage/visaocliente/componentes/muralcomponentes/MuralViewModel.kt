package com.example.homepage.visaocliente.componentes.muralcomponentes

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MuralViewModel : ViewModel() {
    private val avisos = mutableStateListOf<Aviso>()

    init {
        avisos.add(Aviso("Aviso 1", "Descrição do Aviso 1"))
        avisos.add(Aviso("Aviso 2", "Descrição do Aviso 2"))
    }
    fun getAvisos() : List<Aviso> {

        return avisos
    }
}