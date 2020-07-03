package com.michifinder.modelo

data class Usuario(
    val idUsuario: Int,
    val nombre_completo: String?,
    val direccion: String?,
    val distrito: String?,
    val fecha_nacimiento: String?,
    val foto: String?,
    val correo: String?,
    val contrasenia: String?
)