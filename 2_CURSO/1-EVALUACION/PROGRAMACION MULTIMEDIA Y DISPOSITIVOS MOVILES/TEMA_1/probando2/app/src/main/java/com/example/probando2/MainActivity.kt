package com.example.probando2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.probando2.ui.theme.Probando2Theme
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Probando2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    logHelloWorld()
                    imprimir()
                    sentenciaIf()
                    sentenciaWhen()
                }
            }
        }
    }
    private fun logHelloWorld() {
        Log.d("HelloWorldTag", "Hello World")
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

    private fun sentenciaIf() {
        val myNumber = 60
        println("$myNumber")

        if(myNumber <= 10 && myNumber > 5) {
            println("$myNumber es menor o igual a 10 y mayor que 5")
        } else if (myNumber == 60) {
            println("$myNumber es igual a 60")
        } else {
            println("$myNumber es mayor que 10 o menor o igual a 5 y diferente de 60")
        }
    }

    private fun sentenciaWhen() {
        val country = "España"
        println("Estamos en $country.")

        when(country) {
            "España", "Perú", "Argentina" -> {
                println("El idioma es Español")
            } "USA" -> {
                println("El idioma es Inglés")
            } "Francia" -> {
                println("El idioma es Francés")
            } else -> {
                println("No conocemos el idioma")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Probando2Theme {
        Greeting("Android")
    }
}