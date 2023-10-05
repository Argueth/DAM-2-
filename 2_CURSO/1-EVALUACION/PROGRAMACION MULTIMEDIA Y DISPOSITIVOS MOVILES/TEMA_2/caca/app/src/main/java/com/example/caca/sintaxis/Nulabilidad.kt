package com.example.caca.sintaxis

fun main() {
    var name: String? = null

    /**
     * Con las dos exclamaciones se el está diciendo que seguro que no va a ser null.
     * Si lo es la aplicación se rompe.
     */
    //println(name!![3])
    /**
     * Con el interrogante, se le dice que, si no es null, haga algo.
     * En este caso, puesto que name es null, devolverá null.
     * Si no fuese nulo, daría el caracter de la posicon 3.
     */
    println(name?.get(3))

    /**
     * De esta nueva forma, podemos meter un mensaje personalizado para el caso en que name sea nulo.
     * Si no fuese nulo daría el valor del caracter en la posicion 3
     */
    println(name?.get(3) ?: "Es nulo wey")
}

