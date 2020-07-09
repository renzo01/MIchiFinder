package com.michifinder.api

import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.michifinder.modelo.DefaultResponse
import com.michifinder.modelo.responces.ListadoGatosResponse
import com.michifinder.modelo.responces.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {
    @FormUrlEncoded
    @POST("usuario/crear")
    fun createUser(
        @Field("Nombre_completo") Nombre_completo: String,
        @Field("Direccion") Direccion: String,
        @Field("Distrito") Distrito: String,
        @Field("Fecha_Nacimiento") Fecha_Nacimiento: String,
        @Field("Foto") foto: String,
        @Field("correo") correo: String,
        @Field("contrasenia") contrasenia: String
    ): Call<DefaultResponse>

    @FormUrlEncoded
    @POST("usuario/login")
    fun usuarioLogin(
        @Field("correo") correo: String,
        @Field("contrasenia") contrasenia: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @GET("gato/listar")
    fun listadoGatos(): Call<ListadoGatosResponse>
}
