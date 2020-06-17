package com.michifinder.storage

import android.content.Context
import com.michifinder.modelo.Usuario

class SharedPrefManager private constructor(private val mCtx: Context) {

    val isLoggedIn: Boolean
        get() {
            val sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getInt("id", -1) != -1
        }

    val usuario: Usuario
        get() {
            val sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return Usuario(
                sharedPreferences.getInt("idUsuario", -1),
                sharedPreferences.getString("nombre_completo", null),
                sharedPreferences.getString("direccion", null),
                sharedPreferences.getString("distrito", null),
                sharedPreferences.getString("fecha_nacimiento", null),
                sharedPreferences.getString("foto", null),
                sharedPreferences.getString("correo", null),
                sharedPreferences.getString("contrasenia", null)
            )
        }
/*val idUsuario: Int?,
    val nombre_completo: String?,
    val direccion: String?,
    val distrito: String?,
    val fecha_nacimiento: String?,
    val foto: String?,
    val correo: String?,
    val contrasenia: String
* */

    fun guardarUsuario(usuario: Usuario) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt("idUsuario", usuario.idUsuario)
        editor.putString("nombre_completo", usuario.nombre_completo)
        editor.putString("direccion", usuario.direccion)
        editor.putString("distrito", usuario.distrito)
        editor.putString("fecha_nacimiento", usuario.fecha_nacimiento)
        editor.putString("foto", usuario.foto)
        editor.putString("correo", usuario.correo)
        editor.putString("contrasenia", usuario.contrasenia)
        editor.apply()

    }

    fun clear() {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private val SHARED_PREF_NAME = "my_shared_preff"
        private var mInstance: SharedPrefManager? = null

        @Synchronized
        fun getInstance(mCtx: Context): SharedPrefManager {
            if (mInstance == null) {
                mInstance = SharedPrefManager(mCtx)
            }
            return mInstance as SharedPrefManager
        }
    }

}