package com.michifinder.modelo

import com.google.gson.annotations.SerializedName

data class Adopciones(
    @SerializedName("Nombre") val Nombre: String,
    @SerializedName("Edad") val Edad: String,
    @SerializedName("Raza") val Raza: String
)
