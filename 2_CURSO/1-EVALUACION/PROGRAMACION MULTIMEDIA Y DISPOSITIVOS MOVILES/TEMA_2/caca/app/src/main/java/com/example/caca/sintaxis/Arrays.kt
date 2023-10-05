package com.example.caca.sintaxis

fun main() {
    //El array tiene tamaño fijo
    val weekDays = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

    println(weekDays[0])
    println(weekDays.size)
    println(weekDays[0].length)

    //Bucles
    for (position in weekDays.indices) {
        println(weekDays[position])
    }

    for((position, value) in weekDays.withIndex()) {
        println("La posicion $position contiene $value")
    }

    for (weekDay in weekDays) {
        println("Ahora es $weekDay")
    }

}