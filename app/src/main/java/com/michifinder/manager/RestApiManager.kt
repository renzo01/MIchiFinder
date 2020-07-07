package com.michifinder.manager

import com.michifinder.interfaces.ApiServices
import com.michifinder.modelo.responces.DefaultResponse
import com.michifinder.objects.RetrofitClient

class RestApiManager {
    fun registerUsuario(defaultResponse: DefaultResponse,onResult:(DefaultResponse?) -> Unit){
        var retrofit = RetrofitClient.buildService(ApiServices::class.java)
        retrofit.registerUsuario()
    }
}