package com.michifinder.modelo

data class Gato(
    var idGato: Int,
    var nombre: String,
    var raza: String,
    var edad: String,
    var descripcion: String,
    var idMedicamentos: Int,
    var sexo: String,
    var estirilizado: Int,
    var vacunado: Int,
    var foto: String,
    var adoptado: Int
)

