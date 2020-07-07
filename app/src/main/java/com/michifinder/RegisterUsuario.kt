package com.michifinder

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.michifinder.objects.RetrofitClient
import com.michifinder.modelo.responces.DefaultResponse
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
        var nombreCompleto = findViewById<EditText>(R.id.etNombreCompleto)
        var direccion = findViewById<EditText>(R.id.etDireccion)
        var distrito = findViewById<Spinner>(R.id.spDistrito)
        var fechaNacimiento = findViewById<TextView>(R.id.tv_fecha_nacimiento_usuario);
        var correo = findViewById<EditText>(R.id.tv_correo)
        var contrasenia = findViewById<EditText>(R.id.etContrasenia)
        var Registrar = findViewById<Button>(R.id.btnRegistrar)

        var calendarInstance = Calendar.getInstance();
        var anio = calendarInstance.get(Calendar.YEAR);
        var mes = calendarInstance.get(Calendar.MONTH);
        var day = calendarInstance.get(Calendar.DAY_OF_MONTH)
        var saveDate = "";
        var saveFoto = "";
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
            if (distrito === null) {
                spDistrito.requestFocus()
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
            //TODO: Hacer que obtenga la imagen y que guarde
            RetrofitClient.instance.registerUsuario(
                nombreCompleto.text.toString().trim(),
                direccion.text.toString().trim(),
                distrito.toString(),
                saveDate,
                saveFoto,
                correo.text.toString().trim(),
                contrasenia.text.toString()
            ).enqueue(object : Callback<DefaultResponse> {
                override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<DefaultResponse>,
                    response: Response<DefaultResponse>
                ) {
                    Toast.makeText(applicationContext, response.body()?.mensaje, Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
        alreadyCount.setOnClickListener {
            var intent = Intent(this, LoginUsuario::class.java);
            startActivity(intent);
        }
    }
}