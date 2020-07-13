package com.michifinder

import android.content.Context
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.michifinder.api.RetrofitClient
import com.michifinder.modelo.DefaultResponse
import kotlinx.android.synthetic.main.activity_registrar_adopcion.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class RegistrarAdopcion : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_adopcion)
        var intent: Intent = intent
        val sharedPref = getSharedPreferences("usuario", Context.MODE_PRIVATE)
        val date = Calendar.getInstance().time
        val dateFormate = SimpleDateFormat("yy/MM/dd")

        val fechaFormateada = dateFormate.format(date)
        val idGato = intent.getIntExtra("idGato", -1)
        val idUsuario = sharedPref.getInt("IdUsuario", -1)


        btnProcesarAdopcion.setOnClickListener {
            if (fechaFormateada == "" || fechaFormateada == null) {
                Toast.makeText(this, "La fecha no pudo ser obtenida", Toast.LENGTH_LONG).show()
            }
            if (idGato == -1 || idGato == null) {
                Toast.makeText(this, "No se puede usar la sesion del usuario", Toast.LENGTH_LONG)
                    .show()
            }
            if (idUsuario == -1 || idUsuario == null) {
                Toast.makeText(this, "No se puede usar la data del gato", Toast.LENGTH_LONG)
                    .show()
            }
            if (etDni.text.trim().isEmpty()) {
                etDni.error = "Porfavor ingresar el Dni"
                etDni.requestFocus()
                return@setOnClickListener
            }
            if (etDni.text.trim().isEmpty()) {
                etDireccionRef.error = "Porfavor ingresar la direccion de referencia"
                etDireccionRef.requestFocus()
                return@setOnClickListener
            }
            if (etDni.text.trim().isEmpty()) {
                etNumeroCon.error = "Porfavor ingresar el numero de contacto"
                etNumeroCon.requestFocus()
                return@setOnClickListener
            }
            RetrofitClient.instance.registrarAdopcion(
                idUsuario,
                idGato,
                fechaFormateada,
                etDni.text.toString(),
                etDireccionRef.text.toString(),
                etNumeroCon.text.toString()
            ).enqueue(object : Callback<DefaultResponse> {
                override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG)
                        .show()
                }

                override fun onResponse(
                    call: Call<DefaultResponse>,
                    response: Response<DefaultResponse>
                ) {
                    Toast.makeText(applicationContext, "Gracias por adoptar", Toast.LENGTH_LONG)
                        .show()
                    var intent = Intent(applicationContext,ListadoGatos::class.java)
                    startActivity(intent)
                }

            })
        }
    }
}