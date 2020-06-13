package com.michifinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.michifinder.adapters.GatoAdapter
import com.michifinder.listeners.RecycleGatoListener
import com.michifinder.modelo.Gato

class MainActivity : AppCompatActivity() {

    private lateinit var rvLista : RecyclerView
    private lateinit var adapter : GatoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvLista = findViewById(R.id.rvListaGatos)
        adapter = GatoAdapter(getGatos(),R.layout.recyclerview_gatos,this,
            object: RecycleGatoListener {
                override fun onClick(gato: Gato, position: Int){
                    Toast.makeText(this@MainActivity,
                        "El/Ella es ${gato.nombre}",
                        Toast.LENGTH_LONG).show()
                }
            })
        rvLista.layoutManager = LinearLayoutManager(applicationContext)
        rvLista.adapter = adapter
    }
    private fun getGatos():ArrayList<Gato>{
        var lista : ArrayList<Gato> = ArrayList()
        lista.add(Gato("Pelusso","Bengala","Gato parecido a un tigre",R.mipmap.gatobengala))
        lista.add(Gato("Michifuz","British Shothair","Gato muy cariñoso",R.mipmap.gatobritishshorthair))
        lista.add(Gato("Azul","Maine Coon","Gato con lindos ojos",R.mipmap.gatomainecoon))
        lista.add(Gato("Princesa","Persa","Gato muy curioso",R.mipmap.gatopersa))
        lista.add(Gato("Balu","Rag Dool","Gato muy jugueton",R.mipmap.gatoragdool))
        lista.add(Gato("Coco","Savannah","Gato extravagante",R.mipmap.gatosavannah))
        lista.add(Gato("Mini","Siames","Gato de lindo pelaje",R.mipmap.gatosiames))
        lista.add(Gato("Arturo","Sphynx","Gato sin pelo pero jugueton",R.mipmap.gatosphynx))

        return lista
    }
}