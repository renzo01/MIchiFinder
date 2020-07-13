package com.michifinder.modelo

import com.google.gson.annotations.SerializedName

data class Gato(
    @SerializedName("IdGato")
    var idGato: Int,
    @SerializedName("Nombre")
    var nombre: String,
    @SerializedName("Raza")
    var raza: String,
    @SerializedName("Edad")
    var edad: String,
    @SerializedName("Descripcion")
    var descripcion: String,
    @SerializedName("IdMedicamentos")
    var idMedicamentos: String,
    @SerializedName("Sexo")
    var sexo: String,
    @SerializedName("Esterelizado")
    var estirilizado: Int,
    @SerializedName("Vacunado")
    var vacunado: Int,
    @SerializedName("Foto")
    var foto: String,
    @SerializedName("Adoptado")
    var adoptado: Int
)

