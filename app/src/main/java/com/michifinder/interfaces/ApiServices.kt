package com.michifinder.interfaces

import com.michifinder.modelo.Gato
import com.michifinder.modelo.responces.LoginResponse
import com.michifinder.modelo.responces.DefaultResponse
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
    @POST("usuario/login")
    fun usuarioLogin(
        @Field("correo") correo: String,
        @Field("contrasenia") contrasenia: String
    ): Call<LoginResponse>

    /*
     Nombre_completo,
        Direccion,
        Distrito,
        Fecha_Nacimiento,
        Foto,
        correo,
        contrasenia,
    * */
    @Headers("Content-type: application/json")
    @POST("/usuario/login")
    fun registerUsuario(
        @Field("Nombre_completo") Nombre_completo: String,
        @Field("Direccion") Direccion: String,
        @Field("Distrito") Distrito: String,
        @Field("Fecha_Nacimiento") Fecha_Nacimiento: String,
        @Field("Foto") Foto: String,
        @Field("correo") correo: String,
        @Field("contrasenia") contrasenia: String
    ): Call<DefaultResponse>
}