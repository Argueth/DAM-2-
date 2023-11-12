package com.pablo.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("CicloDeVida", "Ingresa a onCreate")
    }

    override fun onStart(){
        super.onStart()
        Log.i("CicloDeVida", "Ingresa a onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.i("CicloDeVida", "Ingresa a onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.i("CicloDeVida", "Ingresa a onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.i("CicloDeVida", "Ingresa a onStop")
    }

    override fun onRestart(){
        super.onRestart()
        Log.i("CicloDeVida", "Ingresa a onRestart")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("CicloDeVida", "Ingresa a onDestroy")
    }
}