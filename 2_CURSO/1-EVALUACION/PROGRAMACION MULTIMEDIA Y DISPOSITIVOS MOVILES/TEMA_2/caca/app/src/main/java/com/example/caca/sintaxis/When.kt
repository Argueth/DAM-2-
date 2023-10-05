package com.example.caca.sintaxis

fun main() {
    println(getMonth(6))
    getTrimester(6)
    getSemester(6)
    resultado(true)
}

fun resultado(value:Any) {
    when(value) {
        is Int -> value + value
        is String -> println(value)
        is Boolean -> if(value) print("holiwi")
    }
}
fun getSemester(month: Int) {
    when(month) {
        in 1..6 -> println("Primer semestre")
        in 7..12 -> println("Segundo semestre")
        !in 1..12 -> println("Semestre no válido") //Se puede negar la condición.
    }
}
fun getTrimester(month:Int) {
    when(month) {
        1, 2, 3 -> println("Primer Trimestre")
        4, 5, 6 -> println("Segundo Trimestre")
        7, 8 ,9 -> println("Tercer Trimestre")
        10, 11, 12 -> println("Cuarto Trimestre")
        else -> println("El mes no existe")
    }
}
fun getMonth(month: Int) = when(month) {
        1 -> "Enero"
        2 -> "Febrero"
        3 -> "Marzo"
        4 -> "Abril"
        5 -> "Mayo"
        6 -> "Junio"
        7 -> "Julio"
        8 -> "Agosto"
        9 -> "Septiembre"
        10 -> "Octubre"
        11 -> "Noviembre"
        12 -> "Diciembre"
        else -> "El mes no existe"
    }
