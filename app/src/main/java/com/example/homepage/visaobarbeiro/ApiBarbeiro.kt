package com.example.homepage.visaobarbeiro

import Barbeiro
import BarbeiroEntity
import SemanaEntity
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiBarbeiro {

    @GET("/barbeiros/listar")
    suspend fun getBarbeiros(@Query("idBarbearia") idBarbearia: Long): List<BarbeiroEntity>

    @PUT("/semana/{idBarbeiro}")
    suspend fun putBarbeiros(@Path("idBarbeiro") idBarbeiro: Long, @Body novaSemana: SemanaEntity)
}