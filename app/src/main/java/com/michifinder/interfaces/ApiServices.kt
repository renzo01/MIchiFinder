package com.michifinder.interfaces

import com.michifinder.modelo.Gato
import com.michifinder.modelo.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {
    //Dato para los gatos
    @GET("gato/listar")
    fun obtenerTodosLosGatos(): Call<List<Gato>>

    @GET("gato/listar/raza")
    fun obtenerPorID(@Body idGato: Gato): Call<Gato>

    @GET("gato/listar/raza")
    fun obtenerPorRaza(@Body raza: Gato): Call<Gato>

    @POST("/usuario/login")
    fun loginUsuario(@Body correo: Usuario, contrasenia: Usuario): Call<Usuario>
}