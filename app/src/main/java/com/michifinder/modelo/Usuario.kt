package com.michifinder.modelo

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("IdUsuarios")
    val IdUsuarios: Int,
    @SerializedName("Nombre_Completo")
    val Nombre_Completo: String?,
    @SerializedName("Direccion")
    val Direccion: String?,
    @SerializedName("Distrito")
    val Distrito: String?,
    @SerializedName("Fecha_Nacimiento")
    val Fecha_Nacimiento: String?,
    @SerializedName("Foto")
    val Foto: String?,
    @SerializedName("Habilitado")
    val Habilitado: Int?,
    @SerializedName("Correo")
    val Correo: String?,
    @SerializedName("Contrasenia")
    val Contrasenia: String?
)