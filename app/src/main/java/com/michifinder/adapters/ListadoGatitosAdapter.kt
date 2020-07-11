package com.michifinder.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.michifinder.R
import com.michifinder.modelo.Gato
import kotlinx.android.synthetic.main.listado_gatitos_content.view.*

/*class ListadoGatitosAdapter(
    var gatitos: List<Gato>
) : RecyclerView.Adapter<ListadoGatitosAdapter.ListadoGatitosViewHolder>() {
    inner class ListadoGatitosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListadoGatitosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listado_gatitos_content, parent, false)
        return ListadoGatitosViewHolder(view)
    }

    override fun getItemCount(): Int = gatitos.size

    override fun onBindViewHolder(holder: ListadoGatitosViewHolder, position: Int) {
        holder.itemView.apply {
            tvNombreGatito.text = gatitos[position].nombre
            tvEdadGatito.text = gatitos[position].edad
            tvRazaGatito.text = gatitos[position].raza
        }
    }
}*/
class ListadoGatitosAdapter(val context: Context, val layout: Int, val gatito: List<Gato>) :
    RecyclerView.Adapter<ListadoGatitosAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(gatito: Gato, context: Context) = with(itemView) {
            tvNombreGatito.text = gatito.nombre
            tvEdadGatito.text = gatito.edad
            tvRazaGatito.text = gatito.raza
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        val vh: ViewHolder = ViewHolder(view)
        return vh
    }

    override fun getItemCount(): Int = gatito.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(gatito[position], context)
    }
}