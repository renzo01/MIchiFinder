package com.michifinder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.michifinder.api.RetrofitClient
import com.michifinder.modelo.Usuario
//import com.michifinder.objects.RetrofitClient
import com.michifinder.modelo.responces.LoginResponse
import com.michifinder.storage.SharedPrefManager
import kotlinx.android.synthetic.main.activity_login_usuario.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_usuario)
        val sharedPref = getSharedPreferences("usuario", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        var tv_register_usuario = findViewById<TextView>(R.id.tv_register_usuario);
        var btn_ingresar_login = findViewById<Button>(R.id.btn_ingresar_login);


        tv_register_usuario.setOnClickListener {
            val intent = Intent(this, RegisterUsuario::class.java);
            startActivity(intent)
        }

        btn_ingresar_login.setOnClickListener {
            var correo = findViewById<TextView>(R.id.tv_correo).text.toString().trim();
            var contrasenia = findViewById<TextView>(R.id.tv_contrasenia).text.toString().trim();

            //Controlling empty field exception
            if (correo.isEmpty()) {
                tv_correo.error = "Coloca un correo"
                tv_correo.requestFocus();
                return@setOnClickListener
            }
            if (contrasenia.isEmpty()) {
                tv_contrasenia.error = "Coloca una contraseña"
                tv_contrasenia.requestFocus();
                return@setOnClickListener
            }
            var intent = Intent(this, ListadoGatos::class.java)
            RetrofitClient.instance.usuarioLogin(correo, contrasenia)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        val usuarioResp = response.body()
                        val usuario: Usuario = usuarioResp!!.usuario
                        editor.apply{
                            putInt("IdUsuario",usuario.IdUsuarios)
                            apply()
                        }

                        Toast.makeText(
                            applicationContext,
                            "Bienvenido ${usuario.Nombre_Completo}",
                            Toast.LENGTH_LONG
                        ).show()

                        startActivity(intent)
                    }
                })

            /* RetrofitClient.instance.usuarioLogin(correo, contrasenia)
                 .enqueue(object : Callback<LoginResponse> {
                     override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                         Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                     }

                     override fun onResponse(
                         call: Call<LoginResponse>,
                         response: Response<LoginResponse>
                     ) {
                         if (response.body()?.ok == true) {
                             SharedPrefManager.getInstance(applicationContext)
                                 .guardarUsuario(response.body()?.result!!)

                             val intent = Intent(applicationContext, ListaGatos::class.java)
                             intent.flags =
                                 Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                             startActivity(intent)

                         } else {
                             Toast.makeText(
                                 applicationContext,
                                 "No se pudo ingresar!!!",
                                 Toast.LENGTH_LONG
                             ).show()
                         }
                     }
                 })*/
        }

    }

    /*override fun onStart() {
        super.onStart()
        if (SharedPrefManager.getInstance(this).isLoggedIn) {
            val intent = Intent(applicationContext, ListadoGatos::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }
    }*/
}