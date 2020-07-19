package com.michifinder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_listado_gatos.*

class ListadoGatos : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_gatos)
        val sharedPref = getSharedPreferences("usuario", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val listadoGatitos = listadoGatitos()
        val ActualizarUsuario = ActualizarUsuario()
        val AdopcinesHechas = AdopcinesHechas()
        val EliminarCuenta = EliminarCuenta()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fPrincipal, listadoGatitos)
            commit()
        }

        toggle = ActionBarDrawerToggle(
            this,
            dlListadoGatos,
            R.string.openNavigation,
            R.string.closeNavigation
        )
        dlListadoGatos.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nvMenu.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fPrincipal, listadoGatitos)
                        commit()
                    }
                }
                R.id.nav_salir -> {
                    var intent = Intent(this, MainActivity::class.java)
                    editor.apply() {
                        remove("IdUsuario")
                        apply()
                    }
                    startActivity(intent)
                }
                R.id.nav_actualizar -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fPrincipal, ActualizarUsuario)
                        commit()
                    }
                }
                R.id.nav_adopciones -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fPrincipal, AdopcinesHechas)
                        commit()
                    }
                }
                R.id.nav_eliminar -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fPrincipal, EliminarCuenta)
                        commit()
                    }
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}