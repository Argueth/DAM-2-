package com.pabloginerbarrios.practica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.cardview.widget.CardView

private lateinit var autocomplete:AutoCompleteTextView
private lateinit var button:CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initAutocomplete()
    }

    fun initComponents() {
        autocomplete = findViewById(R.id.autocomplete)
        button = findViewById(R.id.button)
    }

    fun initAutocomplete(){
        val lenguajes = resources.getStringArray(R.array.lenguajes)
        val adapter = ArrayAdapter(this, android.R.layout.select_dialog_item, lenguajes)
        autocomplete.setAdapter(adapter)
    }
}