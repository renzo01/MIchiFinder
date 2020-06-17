package com.michifinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Detalle_Michi : AppCompatActivity() {
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle__michi)
        setContentView(R.layout.activity_main)

        val btn_ingresar = findViewById<Button>(R.id.btn_ingresar);

        btn_ingresar.setOnClickListener {
            val intent = Intent(this, login_usuario::class.java);

            startActivity(intent)
        }


    }
}