package com.michifinder.interfaces

import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.michifinder.modelo.DefaultResponse
import com.michifinder.modelo.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiServices {
    @FormUrlEncoded
    @POST("createUser")
    fun createUser(
        @Field("Nombre_completo") Nombre_completo: EditText,
        @Field("Direccion") Direccion: EditText,
        @Field("Distrito") Distrito: Spinner,
        @Field("Fecha_Nacimiento") Fecha_Nacimiento: TextView,
        @Field("correo") correo: EditText,
        @Field("contrasenia") contrasenia: EditText
    ) : Call<DefaultResponse>

    @FormUrlEncoded
    @POST("usuario/crear")
    fun usuarioLogin(
        @Field("correo") correo: String,
        @Field("contrasenia") contrasenia: String
    ) : Call<DefaultResponse    >
}
