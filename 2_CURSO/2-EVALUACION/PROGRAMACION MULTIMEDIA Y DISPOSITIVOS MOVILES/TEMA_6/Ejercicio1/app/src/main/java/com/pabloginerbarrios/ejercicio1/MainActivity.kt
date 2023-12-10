package com.pabloginerbarrios.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnPassBundles: androidx.cardview.widget.CardView
    private lateinit var btnNoPassBundle: androidx.cardview.widget.CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()

        btnPassBundles.setOnClickListener { view ->
            onClick(view)
        }
        btnNoPassBundle.setOnClickListener { view ->
            onClick(view)
        }
    }

    fun initComponents() {
        btnPassBundles = findViewById(R.id.button1)
        btnNoPassBundle = findViewById(R.id.button2)
    }

    private fun onClick(view: View) {
        when(view.id) {
            R.id.button1 -> {
                val bundle = Bundle()
                bundle.putString("Key1", "PlainText")
                val intent = Intent(this@MainActivity, SecondActivity::class.java)

                intent.putExtras(bundle)
                startActivity(intent)
            }
            R.id.button2 -> {
                val bundle = Bundle()
                bundle.putString("Key1", "Clear del bundle")
                bundle.clear()
                val intent = Intent(this@MainActivity, SecondActivity::class.java)

                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}