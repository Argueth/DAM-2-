package com.pablo.ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnBoton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var cont: Int = 0
        btnBoton = findViewById<Button>(R.id.boton)
        btnBoton.setOnClickListener {
            cont++
            btnBoton.setText(getString(R.string.textButton, cont))
        }
    }
}