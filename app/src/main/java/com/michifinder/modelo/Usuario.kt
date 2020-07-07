package com.michifinder.modelo

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("idUsuarios")
    val idUsuario: Int,
    @SerializedName("Nombre_completo")
    val nombre_completo: String?,
    @SerializedName("Direccion")
    val direccion: String?,
    @SerializedName("Distrito")
    val distrito: String?,
    @SerializedName("Fecha_Nacimiento")
    val fecha_nacimiento: String?,
    @SerializedName("Foto")
    val foto: String?,
    @SerializedName("correo")
    val correo: String?,
    @SerializedName("contrasenia")
    val contrasenia: String?
)