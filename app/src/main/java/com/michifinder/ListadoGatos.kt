package com.michifinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar

import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class ListadoGatos : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    /*private lateinit var rvLista : RecyclerView
    private lateinit var adapter : GatoAdapter*/
    private lateinit var drawerListadoGatos : DrawerLayout;
    private lateinit var toolbar: Toolbar;
    private lateinit var  navPrincipal : NavigationView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*rvLista = findViewById(R.id.rvListaGatos)
        adapter = GatoAdapter(getGatos(),R.layout.recyclerview_gatos,this,
            object: RecycleGatoListener {
                override fun onClick(gato: Gato, position: Int){
                    Toast.makeText(this@ListadoGatos,
                        "El/Ella es ${gato.nombre}",
                        Toast.LENGTH_LONG).show()
                }
            })
        rvLista.layoutManager = LinearLayoutManager(applicationContext)
        rvLista.adapter = adapter*/
        drawerListadoGatos = findViewById(R.id.dListadoGatos);
        navPrincipal = findViewById(R.id.nvMenu);
        toolbar = findViewById(R.id.toolbar);
        //Configuracion del boton de hambugesa para le toolbar
        setSupportActionBar(toolbar);
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu_hamburger);

        var toggle = ActionBarDrawerToggle(this, drawerListadoGatos, toolbar, R.string.openNavigation,R.string.closeNavigation)
        toggle.isDrawerIndicatorEnabled = true;
        drawerListadoGatos.addDrawerListener(toggle)
        toggle.syncState()
        //nvMenu.setNavigationItemSelectedListener {this}
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
    /*private fun getGatos():ArrayList<Gato>{
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
    }*/
}