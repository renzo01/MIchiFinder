package com.michifinder.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.michifinder.listeners.RecycleGatoListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_gatos.view.*

class GatoAdapter(val gatos: ArrayList<Gato>, val layout: Int, val context : Context,
                  val listener: RecycleGatoListener
) : RecyclerView.Adapter<GatoAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        val vh: ViewHolder = ViewHolder(view)
        return vh
    }

    override fun getItemCount() = gatos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(gatos[position],context,listener)
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun bind (gato: Gato, context: Context, listener: RecycleGatoListener)= with(itemView){
            tvRaza.text = gato.nombreRaza
            Picasso.with(context).load(gato.imgGato).into(ivGato)
            setOnClickListener {
                listener.onClick(gato,adapterPosition)
            }
        }
    }
}
