package com.michifinder.modelo

import com.google.gson.annotations.SerializedName

data class DefaultResponse(
    @SerializedName("ok") val ok: Boolean,
    @SerializedName("mensaje") val mensaje: String
)