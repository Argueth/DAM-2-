def aplicarFUncionBooleana(funcion, lista):
    resultado = []
    for elemento in lista:
        if funcion(elemento):
            resultado.append(elemento)
    return resultado

def comprobarPalabra(palabra):
    if len(palabra)<=5:
        return True
    else:
        return False

def comprobarNumero(n):
    if n <=5:
        return True
    else:
        return False
        
listaPalabras = ['mierda', 'pedo', 'culo', 'pis', 'comer', 'iglesia', 'teatro', 'silla']
listaNumeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print(aplicarFUncionBooleana(comprobarNumero, listaNumeros))