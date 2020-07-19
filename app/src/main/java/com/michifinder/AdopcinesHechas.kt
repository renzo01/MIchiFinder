package com.michifinder

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.michifinder.adapters.ListadoAdopcionesAdapter
import com.michifinder.adapters.ListadoGatitosAdapter
import com.michifinder.api.RetrofitClient
import com.michifinder.modelo.Gato
import com.michifinder.modelo.responces.AdopcionesResponse
import com.michifinder.modelo.responces.ListadoGatosResponse
import kotlinx.android.synthetic.main.fragment_adopcines_hechas.*
import kotlinx.android.synthetic.main.fragment_listado_gatitos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AdopcinesHechas.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdopcinesHechas : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var adapter: ListadoAdopcionesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        getCallListadoAdopciones()
    }
    private fun getCallListadoAdopciones(){
        val preferences =
            activity?.getSharedPreferences("usuario", Context.MODE_PRIVATE)
            val idUsuario = preferences!!.getInt("IdUsuario", -1)
        var resultado: Call<AdopcionesResponse> = RetrofitClient.instance.listarAdopcion(idUsuario)
        resultado.enqueue(object : Callback<AdopcionesResponse>{
            override fun onFailure(call: Call<AdopcionesResponse>, t: Throwable) {
                Toast.makeText(activity,t.message,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<AdopcionesResponse>,
                response: Response<AdopcionesResponse>
            ) {
                val listaGatitos = response.body()
                val gatitos: List<Gato> = listaGatitos!!.adopciones
                cargarInformacion(gatitos)
            }
        })
    }
    private fun cargarInformacion(gatitos: List<Gato>){
        adapter = ListadoAdopcionesAdapter(activity!!, R.layout.listado_gatitos_content,gatitos)
        rvAdopciones.adapter= adapter
        rvAdopciones.layoutManager = LinearLayoutManager(activity)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adopcines_hechas, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AdopcinesHechas.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AdopcinesHechas().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}