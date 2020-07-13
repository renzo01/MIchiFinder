package com.michifinder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.michifinder.api.RetrofitClient
import com.michifinder.modelo.DefaultResponse
import kotlinx.android.synthetic.main.fragment_eliminar_cuenta.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.zip.Inflater

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EliminarCuenta.newInstance] factory method to
 * create an instance of this fragment.
 */
class EliminarCuenta : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        val preferences =
            activity?.getSharedPreferences("usuario", Context.MODE_PRIVATE)


        /* */
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_eliminar_cuenta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preferences =
            activity?.getSharedPreferences("usuario", Context.MODE_PRIVATE)
        btnEliminar.setOnClickListener {
            val idUsuario = preferences!!.getInt("IdUsuario", -1)
            if (idUsuario != -1) {
                RetrofitClient.instance.eliminarusuario(idUsuario)
                    .enqueue(object : Callback<DefaultResponse> {
                        override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                            Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                        }

                        override fun onResponse(
                            call: Call<DefaultResponse>,
                            response: Response<DefaultResponse>
                        ) {
                            Toast.makeText(
                                activity,
                                "Se ha eliminado correctamente",
                                Toast.LENGTH_LONG
                            ).show()
                            preferences.edit().apply(){
                                remove("IdUsuario")
                            }
                            val intent = Intent(activity, MainActivity::class.java)
                            startActivity(intent)
                        }

                    })
            } else {
                Toast.makeText(activity, "El usuario no es valido", Toast.LENGTH_LONG).show()
            }

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EliminarCuenta.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EliminarCuenta().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}