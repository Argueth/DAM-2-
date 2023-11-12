package com.pabloginerbarrios.actividadevaluable

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.skydoves.colorpickerview.ColorEnvelope
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
import com.skydoves.colorpickerview.sliders.AlphaSlideBar
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar


class ColorPicker : AppCompatActivity() {

    private lateinit var colorPickerView: ColorPickerView
    private lateinit var tv: TextView
    private lateinit var l1: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_picker)

        initComponents()
        initListeners()

        val brightnessSlideBar = findViewById<BrightnessSlideBar>(R.id.brightnessSlide)
        val alphaSlideBar = findViewById<AlphaSlideBar>(R.id.alphaSlideBar)

        colorPickerView.attachBrightnessSlider(brightnessSlideBar);
        colorPickerView.attachAlphaSlider(alphaSlideBar);
    }

    private fun initComponents() {
        colorPickerView = findViewById(R.id.colorPickerView)
        l1 = findViewById(R.id.colorLayout)
        tv = findViewById(R.id.colorCode)
    }

    private fun initListeners() {
        colorPickerView.setColorListener(object : ColorEnvelopeListener {
            override fun onColorSelected(envelope: ColorEnvelope, fromUser: Boolean) {
                l1.setBackgroundColor(envelope.color)
                tv.text = "#${envelope.hexCode}"
            }
        })
    }
}