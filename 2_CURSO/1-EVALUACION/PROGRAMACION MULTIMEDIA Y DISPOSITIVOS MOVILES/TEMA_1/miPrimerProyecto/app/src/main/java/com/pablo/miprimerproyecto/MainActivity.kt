package com.pablo.miprimerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        variables()
        imprimir()
        sentenciaIf()
        sentenciaWhen()
    }

    fun variables() {
        val numeroPi = 3.141516

        var x = 2
        var y : Int = 5
        var miNombre: String = "Pablo"
        var miApellido: String = "Giner"
    }

    private fun imprimir() {
        val nombre = "Pablo"
        val apellido = "Giner"
        println("Mi nombre completo es $nombre $apellido")
    }

    private fun sentenciaIf(){
        val myNumber = 50
        println("$myNumber")

        if (myNumber <= 10 && myNumber > 5){
            println("$myNumber es menor o igual a 10 y mayor que 5")
        }else if(myNumber == 60) {
            println("$myNumber es igual a 60")
        }else {
            println("$myNumber es menor que 5 o mayor que 10 y, siempre, distinto de 60.")
        }
    }

    private fun sentenciaWhen() {
        val country = "España"

        when(country) {
            "España", "Perú", "Argentina" -> {println("El idioma es español.")}
            "USA" -> {println("El idioma es inglés.")}
            "Francia" -> {println("El idioma es francés.")}
            else -> {println("No conocemos el idioma.")}
        }
    }
}