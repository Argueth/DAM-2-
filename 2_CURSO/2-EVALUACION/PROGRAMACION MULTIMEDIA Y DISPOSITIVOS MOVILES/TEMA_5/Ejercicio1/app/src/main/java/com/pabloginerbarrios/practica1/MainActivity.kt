package com.pabloginerbarrios.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup

private lateinit var ninguno: RadioButton
    private lateinit var grupo: RadioGroup
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        ninguno.isChecked = true
        initListeners()
    }

    fun initComponents() {
        ninguno = findViewById<RadioButton>(R.id.ninguno)
        grupo = findViewById(R.id.radiogroup)
    }

    fun initListeners() {
        grupo.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.ninguno -> Log.d("pantalla", "Ninguno")
                R.id.ganymede -> Log.d("pantalla", "Ganymede")
                R.id.luna -> Log.d("pantalla", "Luna")
                R.id.saturno -> Log.d("pantalla", "Satruno")
                R.id.pluton -> Log.d("pantalla", "Plutón")
            }
        }
    }
}