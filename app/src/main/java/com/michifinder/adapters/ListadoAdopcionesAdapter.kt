package com.michifinder.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.michifinder.modelo.Gato
import kotlinx.android.synthetic.main.listado_gatitos_content.view.*

class ListadoAdopcionesAdapter(val context: Context, val layout: Int, val gatito: List<Gato>) :
    RecyclerView.Adapter<ListadoAdopcionesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(gatito: Gato, context: Context) = with(itemView) {
            tvNombreGatito.text = gatito.nombre
            tvEdadGatito.text = gatito.edad
            tvRazaGatito.text = gatito.raza
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListadoAdopcionesAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        val vh: ListadoAdopcionesAdapter.ViewHolder = ListadoAdopcionesAdapter.ViewHolder(view)
        return vh
    }

    override fun getItemCount(): Int = gatito.size

    override fun onBindViewHolder(holder: ListadoAdopcionesAdapter.ViewHolder, position: Int) {
        holder.bind(gatito[position], context)
    }

}