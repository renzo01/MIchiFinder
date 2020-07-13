package com.michifinder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_detalle_gato.*

class DetalleGato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_gato)
        val btnAdoptar = findViewById<Button>(R.id.btn_Adoptar)

        var intent: Intent = intent
        val idGato: Int = intent.getIntExtra("IdGato", 0)
        val nombre: String = intent.getStringExtra("Nombre")
        val Raza: String = intent.getStringExtra("Raza")
        val Edad: String = intent.getStringExtra("Edad")
        val Descripcion: String = intent.getStringExtra("Descripcion")
        val IdMedicamentos: String = intent.getStringExtra("IdMedicamentos")
        val Sexo: String = intent.getStringExtra("Sexo")
        val Estirilizado: Int = intent.getIntExtra("Estirilizado", 0)
        val Vacunado: Int = intent.getIntExtra("Vacunado", 0)

        tvNombreGatitoDetalle.text = nombre
        tvRazaGatitoDetalle.text = Raza
        tvEdadGatitoDetalle.text = Edad
        tvDescripcionGatitoDetalle.text = Descripcion
        tvMedicamentoGatitoDetalle.text = IdMedicamentos
        tvSexoGatitoDetalle.text = Sexo

        if (Estirilizado == 1) {
            tvEsterilizadoGatito.text = "SI"
        } else {
            tvEsterilizadoGatito.text = "NO"
        }
        if (Vacunado == 1) {
            tvVacunadoGatitoDetalle.text = "SI"
        } else {
            tvVacunadoGatitoDetalle.text = "NO"
        }

        btnAdoptar.setOnClickListener {
            var intent = Intent(this, RegistrarAdopcion::class.java).putExtra("idGato", idGato)
            startActivity(intent)
        }

    }
}