package com.michifinder.modelo

class Usuario(
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
}

