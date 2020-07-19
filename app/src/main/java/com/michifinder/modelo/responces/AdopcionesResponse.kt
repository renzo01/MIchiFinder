package com.michifinder.modelo.responces

import com.google.gson.annotations.SerializedName
import com.michifinder.modelo.Adopciones
import com.michifinder.modelo.Gato

data class AdopcionesResponse(
    @SerializedName("adopciones") val adopciones: List<Gato>
)