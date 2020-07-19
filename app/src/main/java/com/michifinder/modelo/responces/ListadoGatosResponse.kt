package com.michifinder.modelo.responces

import com.google.gson.annotations.SerializedName
import com.michifinder.modelo.Gato

data class ListadoGatosResponse(
   // @SerializedName("ok") val ok: Boolean,
    @SerializedName("gatos") val gatos: List<Gato>
)