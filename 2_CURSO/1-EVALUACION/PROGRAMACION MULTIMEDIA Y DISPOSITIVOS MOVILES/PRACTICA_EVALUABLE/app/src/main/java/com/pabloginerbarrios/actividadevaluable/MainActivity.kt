package com.pabloginerbarrios.actividadevaluable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var colorPicker: CardView
    private lateinit var dmxCalculator : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initListeners()

    }

    private fun initComponents() {
        colorPicker = findViewById(R.id.cardColorPicker)
        dmxCalculator = findViewById(R.id.cardDmxCalculator)
    }

    private fun initListeners() {
        colorPicker.setOnTouchListener { view, event ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    colorPicker.setCardBackgroundColor(ContextCompat.getColor(view.context,R.color.pressedButtonColor))
                    val intent = Intent(this, ColorPicker::class.java)
                    startActivity(intent)
                }
                MotionEvent.ACTION_UP -> colorPicker.setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.cardBackground))
            }
            true
        }
        dmxCalculator.setOnTouchListener { view, event ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    dmxCalculator.setCardBackgroundColor(ContextCompat.getColor(view.context,R.color.pressedButtonColor))
                    val intent = Intent (this, DmxCalculator::class.java)
                    startActivity(intent)
                }
                MotionEvent.ACTION_UP -> dmxCalculator.setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.cardBackground))
            }
            true
        }
    }
}