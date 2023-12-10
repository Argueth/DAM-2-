package com.pabloginerbarrios.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var txtString: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        txtString = findViewById(R.id.text2)

        val bundle = intent.extras

        val key1Value = bundle?.getString("Key1", "Ningún valor del MainActivity :(")

        txtString.text = key1Value
    }
}