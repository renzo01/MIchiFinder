package com.michifinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.michifinder.adapters.ListadoGatitosAdapter
import com.michifinder.api.ApiServices
import com.michifinder.api.RetrofitClient
import com.michifinder.modelo.Gato
import com.michifinder.modelo.responces.ListadoGatosResponse
import kotlinx.android.synthetic.main.fragment_listado_gatitos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [listadoGatitos.newInstance] factory method to
 * create an instance of this fragment.
 */
class listadoGatitos : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var adapter: ListadoGatitosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        getCalllistGatitos()
    }

    private fun getCalllistGatitos() {
        var resultado: Call<ListadoGatosResponse> = RetrofitClient.instance.listadoGatos()
        resultado.enqueue(object : Callback<ListadoGatosResponse> {
            override fun onFailure(call: Call<ListadoGatosResponse>, t: Throwable) {
                Toast.makeText(activity,t.message,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<ListadoGatosResponse>,
                response: Response<ListadoGatosResponse>
            ) {
                val listaGatitos = response.body()
                val gatitos: List<Gato> = listaGatitos!!.gatos
                Toast.makeText(activity,
                    "Se encontraron ${gatitos.size}",
                    Toast.LENGTH_LONG).show()
                cargarInformacion(gatitos)
            }

        })
    }
    private fun cargarInformacion(gatitos: List<Gato>){
        adapter = ListadoGatitosAdapter(activity!!, R.layout.listado_gatitos_content,gatitos)
        rvListadoGatitos.adapter= adapter
        rvListadoGatitos.layoutManager = LinearLayoutManager(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listado_gatitos, container, false)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment listadoGatitos.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            listadoGatitos().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}