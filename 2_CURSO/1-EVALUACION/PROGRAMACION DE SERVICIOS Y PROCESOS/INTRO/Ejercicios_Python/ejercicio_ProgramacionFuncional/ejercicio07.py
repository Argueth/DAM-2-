def aplicarNota(nota):
    if nota < 5:
        return 'Suspendido'
    elif nota <6:
        return 'Suficiente'
    elif nota < 7:
        return 'Bien'
    elif nota < 9:
        return 'Notable'
    elif nota < 11:
        return 'Sobresaliente'
    else:
        return "ERROR. Nota no válida."

def ponerNotas(diccionario):
    listaCalificaciones= {}
    for clave, valor in diccionario.items():
        listaCalificaciones[clave] = aplicarNota(valor)
    return listaCalificaciones

diccionario = {'Matemáticas':7, 'Física':5.6, 'Castellano':8, 'Historia':10}

print("-----CALIFICACIONES-----")
for clave,valor in ponerNotas(diccionario).items():
    print(f"{clave.upper()}: \t {valor}")
