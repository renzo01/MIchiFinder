package com.michifinder

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.michifinder.api.RetrofitClient
import com.michifinder.modelo.DefaultResponse
import kotlinx.android.synthetic.main.activity_register_usuario.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterUsuario : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_usuario)
        var alreadyCount = findViewById<TextView>(R.id.tv_already_count);
        val nombreCompleto = findViewById<EditText>(R.id.etNombreCompleto)
        val direccion = findViewById<EditText>(R.id.etDireccion)
        val distrito = findViewById<Spinner>(R.id.spDistrito)
        val fechaNacimiento = findViewById<TextView>(R.id.tv_fecha_nacimiento_usuario);
        val correo = findViewById<EditText>(R.id.etCorreo)
        val contrasenia = findViewById<EditText>(R.id.etContrasenia)
        val Registrar = findViewById<Button>(R.id.btnRegistrar)
        val foto:String  = "Aqui deberia ir la imagen"
        val calendarInstance = Calendar.getInstance();
        val anio = calendarInstance.get(Calendar.YEAR);
        val mes = calendarInstance.get(Calendar.MONTH);
        val day = calendarInstance.get(Calendar.DAY_OF_MONTH)
        var saveDate = "";
        fechaNacimiento.setOnClickListener {
            var dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    saveDate = "" + year + "-" + month + "-" + dayOfMonth
                    fechaNacimiento.setText(saveDate);

                }, anio, mes, day
            )
            dpd.show()
        }
        Registrar.setOnClickListener {
            if (nombreCompleto.text.toString().trim().isEmpty()) {
                etNombreCompleto.error = "Porfavor ingrese su nombre"
                etNombreCompleto.requestFocus()
                return@setOnClickListener
            }
            if (direccion.text.toString().trim().isEmpty()) {
                etDireccion.error = "Porfavor ingrese su dirección"
                etDireccion.requestFocus()
                return@setOnClickListener
            }
            if (fechaNacimiento.text.toString().trim().isEmpty()) {
                tv_fecha_nacimiento_usuario.error = "Porfavor ingrese su nombre"
                tv_fecha_nacimiento_usuario.requestFocus()
                return@setOnClickListener
            }
            if (correo.text.toString().trim().isEmpty()) {
                etCorreo.error = "Porfavor ingrese su nombre"
                etCorreo.requestFocus()
                return@setOnClickListener
            }
            if (contrasenia.text.toString().trim().isEmpty()) {
                etContrasenia.error = "Porfavor ingrese su nombre"
                etContrasenia.requestFocus()
                return@setOnClickListener
            }
            RetrofitClient.instance.createUser(
                nombreCompleto.text.toString(),
                direccion.text.toString(),
                distrito.selectedItem.toString(),
                fechaNacimiento.text.toString(),
                foto,
                correo.text.toString(),
                contrasenia.text.toString()
            )
                .enqueue(object : Callback<DefaultResponse> {
                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                    override fun onResponse(
                        call: Call<DefaultResponse>,
                        response: Response<DefaultResponse>
                    ) {
                        Toast.makeText(
                            applicationContext,
                            "Se ha registrado correctamente",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                })
        }

        alreadyCount.setOnClickListener {
            var intent = Intent(this, LoginUsuario::class.java);
            startActivity(intent);
        }
    }
}