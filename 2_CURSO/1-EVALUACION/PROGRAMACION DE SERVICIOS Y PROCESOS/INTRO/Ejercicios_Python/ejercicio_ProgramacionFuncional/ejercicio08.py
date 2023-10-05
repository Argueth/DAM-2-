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

def asignaturasAprobadas(asignatura):
    return (asignatura[1] >= 5)

def ponerNotas(diccionario):
    aprobadas = dict(filter(asignaturasAprobadas, diccionario.items()))
    asignaturas = map(str.upper, aprobadas.keys())
    notas = map(aplicarNota, aprobadas.values())
    return dict(zip(asignaturas, notas))

diccionario = {'Inglés':4, 'Matemáticas':7, 'Física':5.6, 'Castellano':8, 'Historia':10}

print("-----CALIFICACIONES-----")
for clave,valor in ponerNotas(diccionario).items():
    print(f"{clave}: \t {valor}")