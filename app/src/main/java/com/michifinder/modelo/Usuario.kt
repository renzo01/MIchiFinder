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

/*class Usuario(
    idUsuario: Int?,
    nombre_completo: String?,
    direccion: String?,
    distrito: String?,
    fecha_nacimiento: String?,
    foto: String?,
    correo: String,
    contrasenia: String
) {
    init {

    }
    constructor(correo: String, contrasenia: String): this(null,null,null,null,null,null,correo,contrasenia){};
}*/

