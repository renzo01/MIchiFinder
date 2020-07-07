package com.michifinder.modelo.responces

import com.google.gson.annotations.SerializedName
import com.michifinder.modelo.Usuario

data class LoginResponse(
    @SerializedName("ok") val ok: Boolean?,
    @SerializedName("usuario") val usuario: Usuario?
)