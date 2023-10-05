package com.example.caca.sintaxis

/**
 *Comentario multilínea.
 */
fun main() {
    println("Hola Mundo")

    //Si lo declaro como val (valor) no se puede reasignar el valor. Es una constante.
    val name = "Pablo" //Kotlin adivina el tipo de variable k es. Si quiero especificarlo le pongo : y el tipo de variable.

    //Para reasignar el valor se tiene que declarar como var (variable).
    var surname = "Giner"

    variablesAlfanumericas()
    variablesAlfanumericas()
    operarVariables()

    showMyName("Pablo")
    showMyAge()
    add(5, 7)
    val mySubstract = substract(5, 3)
    println(mySubstract)
    println(substractCool(10, 5))
}

fun add(firstNumber:Int, secondNumber:Int) {
    println("Función sumar: ")
    println("$firstNumber + $secondNumber = ${firstNumber + secondNumber}")
}

fun substract(firstNumber: Int, secondNumber: Int): Int { //se debe indicar el tipo de variable que va a devolver.
    return firstNumber - secondNumber
}

fun substractCool(firstNumber: Int, secondNumber: Int): Int = firstNumber - secondNumber //Otro modo de poner lo mismo.

fun showMyName(name:String) {
    println("Me llamo $name")
}
fun showMyAge(currentAge:Int = 33) { //Al poner el igual, 30 es el valor por defecto en caso de no mandar ningun parámetro.
    println("Tengo $currentAge años")
}
fun variablesAlfanumericas() {
    /**
     * Variables alfanuméricas
     */
    //Char. Solo soporta un carácter.
    val charExample1: Char = 'a' //Se pone el carácter entre comillas simples.
    val charExample2: Char = '2' //Este número no es el número, sino el caracter 2.
    val charExample3: Char = '@' //Se puede poner cualquier carácter.

    //String. Cadena de caracteres. De la longitud que se quiera.
    val stringExample: String = "Hola Mundo"
    println(stringExample)
    val stringExample2 = "Gilipollas"
    println(stringExample + " " + stringExample2) //Para concatenar cadenas de caracteres.
    val stringConcatenada: String ="Hola $stringExample2" //Signo de dolar $ para hacer referencia a una variable dentro de una String
    println(stringConcatenada)
}

fun variablesBooleanas() {
    /**
     * Variables Booleanas
     */
    //Boolean
    val booleanExample1: Boolean = true
    val booleanExample2: Boolean = false



    operarVariables() //Llamado a una función.
}
fun operarVariables() { //Creación de una función.

    /**
     * Variables numéricas.
     */
    //Int desde -2,147,483,647 hasta 2,147,483,647
    val age: Int = 30

    //Long --> Lo mismo k Int pero más grande. desde -9,223,372,036,854,775,807 hasta 9,223,372,036,854,775,807
    val example: Long = 15 //Puedo poner 30, pero es un desperdicio de memoria. Solo para números enormes.
    val example2 = 30 //En este caso, Kotlin entiende que esto es un Int, no un Long. Por eso es importante saber cuando es bueno poner el tipo de variable.

    //FLoat. Hasta 6 decimales.
    val floatExample: Float = 8.45f
    floatExample.toInt() //Para convertir, en este caso, un float, en un entero.
    //Double. Hasta 14 decimales.
    val doubleExample: Double = 34534.65435473472

    /**
     * Operar con variables
     */
    println("Sumar: ")
    println("$age - $example = ${age + example}")

    println("Restar: ")
    println("$example - $floatExample = ${example - floatExample}")

    println("Multiplicar: ")
    println("$age * $example = ${age * example}")

    println("Dividir: ")
    println("$age / $example = ${age / example}")

    println("Modulo: ")
    println("$age % $example = ${age % example}")
}