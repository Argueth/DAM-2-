package com.pabloginerbarrios.evaluable_2

import android.graphics.Bitmap
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.skydoves.colorpickerview.ColorEnvelope
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
import com.skydoves.colorpickerview.sliders.AlphaSlideBar
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar
import android.graphics.drawable.BitmapDrawable

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

        val imageView = ImageView(this)

        colorPickerView.attachBrightnessSlider(brightnessSlideBar);
        colorPickerView.attachAlphaSlider(alphaSlideBar);

        //val defaultDrawable = ContextCompat.getDrawable(this, R.drawable.imagen)
        //colorPickerView.setPaletteDrawable(defaultDrawable)

        if (ImageSingleton.capturedBitmap != null) {
            Log.d("imagen", "La imagen está en el singleton")
            val bitmapDrawable = BitmapDrawable(resources, ImageSingleton.capturedBitmap)

            val rotatedBitmap = rotateBitmap(bitmapDrawable.bitmap, 90f)

            colorPickerView.setPaletteDrawable(BitmapDrawable(resources, rotatedBitmap));
        }else {
            Log.d("imagen", "La imagen no está en el singleton")
        }
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

    private fun rotateBitmap(bitmap: Bitmap, degrees: Float): Bitmap {
        // Rotar la imagen 90 grados
        val matrix = Matrix()
        matrix.postRotate(degrees)
        return Bitmap.createBitmap(
            bitmap,
            0, 0,
            bitmap.width,
            bitmap.height,
            matrix,
            true
        )
    }
}