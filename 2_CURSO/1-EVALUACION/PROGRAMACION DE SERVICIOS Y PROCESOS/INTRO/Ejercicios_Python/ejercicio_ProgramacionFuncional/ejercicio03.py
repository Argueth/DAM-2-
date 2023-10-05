def aplicarFuncion(funcion, lista):
    resultado = []
    for n in lista:
        resultado.append(funcion(n))
    return resultado

def duplicador(n):
    return n*2

def cuadrado(n):
    return n**2

lista = [1, 2, 3, 4, 5]

print(aplicarFuncion(duplicador, lista))
print(aplicarFuncion(cuadrado, lista))