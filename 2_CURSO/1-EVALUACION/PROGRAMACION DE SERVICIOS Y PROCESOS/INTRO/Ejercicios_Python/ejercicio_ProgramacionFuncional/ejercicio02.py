from math import sin, cos, tan, exp, log

def aplicarFuncion(n, funcion):
    funciones = {'seno':sin, 'coseno':cos, 'tangente':tan, 'exponencial':exp, 'logaritmo':log}

    resultado = {}
    for i in range(1, n+1):
        resultado[i]=funciones[funcion](i)

    return resultado

def calculadora():
    funcion = input("Introduce la función que quieres usar (seno, coseno, tengente, exponencial, logaritmo): ")
    n = int(input("Introduce un número entero positivo: "))

    for i, j in aplicarFuncion(n, funcion).items():
        print(i, "\t", round(j, 2))
    
    return

calculadora()