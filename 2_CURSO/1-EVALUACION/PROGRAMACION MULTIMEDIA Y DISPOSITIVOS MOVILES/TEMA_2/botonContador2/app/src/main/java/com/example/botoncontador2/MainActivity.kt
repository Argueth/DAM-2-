package com.example.botoncontador2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var boton1: Button
    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton1 = findViewById(R.id.boton1)
        boton1.setOnClickListener {
            contador++
            boton1.text="Ha sido pulsado $contador veces"
        }
    }
}