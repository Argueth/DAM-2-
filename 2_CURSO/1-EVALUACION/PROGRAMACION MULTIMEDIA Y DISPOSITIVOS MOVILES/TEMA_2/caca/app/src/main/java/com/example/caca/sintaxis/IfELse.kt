package com.example.caca.sintaxis

fun main() {
    ifBasico()
    ifAnidado()
    ifBoolean()
    ifInt()
    ifMultiple()
}

fun ifMultiple() {
    var age = 18
    var parentPermission = false
    var imHappy = true
    /*
    Operaciones lógicas:
    && AND
    || OR
     */
    if(age >=18 && parentPermission && imHappy) {
        println("Beber cervecita")
    }else {
        println("Me cago en todo.")
    }

}

fun ifInt() {
    var age = 33

    /*
    Posibles comparaciones con números:
    < Menor que
    > Mayor que
    <= Menos o igual que
    >= Mayor o igual que
    == Igual que
     */
    if(age >= 18) {
        println("Beber cerveza")
    }else {
        println("Beber un jugo")
    }
}

fun ifBoolean() {
    var soyFeliz = true

    if(soyFeliz) { //Para negar la condición le metemos el NOT logico con el ! delante.
        println("guay!!")
    }else {
        println("Estoy triste :(")
    }
}
fun ifAnidado() {
    val animal = "dog"

    if(animal == "dog") {
        println("Es un perrito!!")
    }else if(animal == "cat") {
        println("Es un gatito!!")
    }else if(animal == "bird") {
        println("Es un pajarito!!")
    }else {
        println("No es ni un perro, ni un gato ni un pajaro...")
    }
}

fun ifBasico() {
    val name = "Pablo"

    if(name == "pepe") {
        println(name)
    }else {
        println("eres gilipollas")
    }
}