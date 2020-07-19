package com.michifinder

import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import com.michifinder.api.RetrofitClient
import com.michifinder.modelo.DefaultResponse
import kotlinx.android.synthetic.main.activity_register_usuario.*
import kotlinx.android.synthetic.main.fragment_actualizar_usuario.*
import kotlinx.android.synthetic.main.fragment_actualizar_usuario.etDireccion
import kotlinx.android.synthetic.main.fragment_actualizar_usuario.etNombreCompleto
import kotlinx.android.synthetic.main.fragment_actualizar_usuario.tv_fecha_nacimiento_usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ActualizarUsuario.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActualizarUsuario : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actualizar_usuario, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preferences =
            activity?.getSharedPreferences("usuario", Context.MODE_PRIVATE)
        val idUsuario = preferences!!.getInt("IdUsuario", -1)
        val foto = "Foto actulizada"
        val distrito = activity?.findViewById<Spinner>(R.id.spDistrito)
        val fechaNacimiento = activity?.findViewById<TextView>(R.id.tv_fecha_nacimiento_usuario)
        val calendarInstance = Calendar.getInstance();
        val anio = calendarInstance.get(Calendar.YEAR);
        val mes = calendarInstance.get(Calendar.MONTH);
        val day = calendarInstance.get(Calendar.DAY_OF_MONTH)
        var saveDate = "";
        fechaNacimiento?.setOnClickListener {
            var dpd = DatePickerDialog(
                this.context!!,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    saveDate = "" + year + "-" + month + "-" + dayOfMonth
                    fechaNacimiento.setText(saveDate);

                }, anio, mes, day
            )
            dpd.show()

        }
        btnActualizarUsuario.setOnClickListener {

            if (idUsuario != -1) {
                if (etNombreCompleto.text.toString().trim().isEmpty()) {
                    etNombreCompleto.error = "Porfavor ingrese su nombre"
                    etNombreCompleto.requestFocus()
                    return@setOnClickListener
                }
                if (etDireccion.text.toString().trim().isEmpty()) {
                    etDireccion.error = "Porfavor ingrese su dirección"
                    etDireccion.requestFocus()
                    return@setOnClickListener
                }
                if (tv_fecha_nacimiento_usuario.text.toString().trim().isEmpty()) {
                    tv_fecha_nacimiento_usuario.error = "Porfavor ingrese su nombre"
                    tv_fecha_nacimiento_usuario.requestFocus()
                    return@setOnClickListener
                }
                RetrofitClient.instance.actualizarUsuario(
                    idUsuario,
                    etNombreCompleto.text.toString(),
                    etDireccion.text.toString(),
                    distrito?.selectedItem.toString(),
                    fechaNacimiento?.text.toString(),
                    foto
                ).enqueue(object : Callback<DefaultResponse> {
                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<DefaultResponse>,
                        response: Response<DefaultResponse>
                    ) {
                        Toast.makeText(activity, "Se actualizado correctamente", Toast.LENGTH_LONG)
                            .show()
                    }

                })
            } else {
                Toast.makeText(activity, "El usuario no es Valido", Toast.LENGTH_LONG).show()
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
         * @return A new instance of fragment ActualizarUsuario.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ActualizarUsuario().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}