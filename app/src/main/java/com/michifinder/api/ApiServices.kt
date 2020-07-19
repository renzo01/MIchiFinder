package com.michifinder.api

import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.michifinder.modelo.DefaultResponse
import com.michifinder.modelo.responces.AdopcionesResponse
import com.michifinder.modelo.responces.ListadoGatosResponse
import com.michifinder.modelo.responces.LoginResponse
import retrofit2.Call
import retrofit2.http.*

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

    @GET("gato/listar")
    fun listadoGatos(): Call<ListadoGatosResponse>

    @FormUrlEncoded
    @POST("adopcion/crear")
    fun registrarAdopcion(
        @Field("IdUsuario") IdUsaurio: Int,
        @Field("IdGato") IdGato: Int,
        @Field("Fecha_Adopcion") Fecha_Adopcion: String,
        @Field("DNI") DNI: String,
        @Field("direccion_referencia") direccion_referencia: String,
        @Field("numero_contacto") numero_contacto: String
    ): Call<DefaultResponse>

    @FormUrlEncoded
    @PUT("usuario/eliminar")
    fun eliminarusuario(
        @Field("IdUsuarios") IdUsuarios: Int
    ): Call<DefaultResponse>

    @FormUrlEncoded
    @PUT("usuario/actualizar")
    fun actualizarUsuario(
        @Field("IdUsuarios") IdUsuarios: Int,
        @Field("Nombre_completo") Nombre_completo: String,
        @Field("Direccion") Direccion: String,
        @Field("Distrito") Distrito: String,
        @Field("Fecha_Nacimiento") Fecha_Nacimiento: String,
        @Field("Foto") foto: String
    ): Call<DefaultResponse>

    @FormUrlEncoded
    @POST("adopcion/listar")
    fun listarAdopcion(
        @Field("IdUsuarios") IdUsuarios: Int
    ): Call<AdopcionesResponse>
}
