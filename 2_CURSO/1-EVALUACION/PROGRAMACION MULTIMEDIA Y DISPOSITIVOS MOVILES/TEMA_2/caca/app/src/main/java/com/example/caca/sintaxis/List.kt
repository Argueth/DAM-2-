package com.example.caca.sintaxis

fun main() {
    //inmutableList()

    mutableList()
}

fun mutableList() {
    var weekDays:MutableList<String> = mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    println(weekDays)

    weekDays.add("Pabloday")
    println(weekDays)

    weekDays.add(0, "Yolanday")
    println(weekDays)

    if (weekDays.isEmpty()) {
        println("La lista esta vacía")
    } else {
        println(weekDays)
    }

    if(weekDays.isNotEmpty()) {
        println(weekDays)
    }else {
        println("La lista está vacía")
    }

    for(item in weekDays) {
        println(item)
    }

    weekDays.forEach { println(it) }
}

fun inmutableList() {
    //Esto es una lista inmutable
    val readOnly:List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

    println(readOnly.size)
    println(readOnly)
    println(readOnly.toString())
    println(readOnly[0])
    println(readOnly.last())
    println(readOnly.first())

    //Filtrar
    val example = readOnly.filter { it.contains("a") }
    println(example)

    readOnly.forEach { println("Siempre habrá un $it") }

    readOnly.forEach { weekDay -> println("Hoy es $weekDay") }
}