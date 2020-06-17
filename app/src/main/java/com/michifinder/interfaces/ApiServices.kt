package com.michifinder.interfaces

import com.michifinder.modelo.Gato
import com.michifinder.modelo.LoginResponse
import com.michifinder.modelo.Usuario
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    //Dato para los gatos
    @GET("gato/listar")
    fun obtenerTodosLosGatos(): Call<List<Gato>>

    @GET("gato/listar/raza")
    fun obtenerPorID(@Body idGato: Gato): Call<Gato>

    @GET("gato/listar/raza")
    fun obtenerPorRaza(@Body raza: Gato): Call<Gato>

    @FormUrlEncoded
    @POST("usuario/crear")
    fun usuarioLogin(
        @Field("correo") correo: String,
        @Field("contrasenia") contrasenia: String
    ) : Call<LoginResponse>
}