package com.example.tema2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        variables()
        imprimir()
        sentenciaIf()
        sentenciaWhen("España")
    }

    private fun sentenciaWhen(country: String) {
        when(country) {
            "España", "Perú", "Argentina" -> println("El idioma es el español.")
            "USA" -> println("El idioma es inglés.")
            "Francia" -> println("El idioma es francés.")
            else -> println("No conocemos el idioma")
        }
    }

    private fun sentenciaIf() {

        val n = 1
        val m = 2

        if ((n+m) < 3) {
            println(n+m)
        } else {
            println("El resultado está fuera del rango.")
        }
    }

    private fun variables() {
        val numeroPi = 3.141516

        var x = 2
        var y: Int = 5
        var miNombre: String = "Pablo"
    }

    private fun imprimir() {

        val nombre = "Pablo"
        val apellido = "Giner"
        println("Mi nombre completo es $nombre $apellido")
    }
}