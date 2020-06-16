package com.michifinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.michifinder.interfaces.ApiServices
import com.michifinder.modelo.Usuario
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class login_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_usuario)

        var retrofit: Retrofit = Retrofit.Builder().baseUrl("http://localhost:3001/")
            .addConverterFactory(GsonConverterFactory.create()).build();
        var service = retrofit.create<ApiServices>(ApiServices::class.java)
        var tv_correo = findViewById<TextView>(R.id.tv_correo);
        var tv_contrasenia = findViewById<TextView>(R.id.tv_contrasenia);
        var btn_ingresar_login = findViewById<Button>(R.id.btn_ingresar_login);

        var usuario: Usuario?= Usuario(tv_correo.text as String, tv_contrasenia.text as String)

        if (usuario != null) {
            //service.loginUsuario(usuario)
        }
        btn_ingresar_login.setOnClickListener {

        }
    }
}