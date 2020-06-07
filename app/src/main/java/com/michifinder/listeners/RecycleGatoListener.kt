package com.michifinder.listeners

import com.michifinder.modelo.Gato

interface RecycleGatoListener{
    fun onClick(gato: Gato, position : Int)
}