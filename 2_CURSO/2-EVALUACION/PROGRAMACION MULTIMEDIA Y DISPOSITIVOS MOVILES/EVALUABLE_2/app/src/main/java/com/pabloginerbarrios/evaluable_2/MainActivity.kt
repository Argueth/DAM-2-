package com.pabloginerbarrios.evaluable_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var button: androidx.appcompat.widget.AppCompatButton
    private lateinit var buttonCamara: androidx.appcompat.widget.AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ImageSingleton.capturedBitmap = null

        initComponents()
        initListeners()
    }

    override fun onRestart() {
        super.onRestart()
        ImageSingleton.capturedBitmap = null
    }

    fun initComponents() {
        button = findViewById(R.id.button)
        buttonCamara = findViewById(R.id.buttoncamara)
    }

    fun initListeners() {
        button.setOnClickListener() {
            val intent = Intent(this, ColorPicker::class.java)
            startActivity(intent)
        }

        buttonCamara.setOnClickListener() {
            val intent = Intent(this, Camara::class.java)
            startActivity(intent)
        }
    }
}