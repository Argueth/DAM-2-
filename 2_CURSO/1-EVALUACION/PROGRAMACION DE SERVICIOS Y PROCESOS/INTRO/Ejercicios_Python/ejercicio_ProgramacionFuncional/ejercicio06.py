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

def aplicarNotificaciones(notas):

    return list(map(aplicarNota, notas))

notas = [5.6, 8 ,9 ,7 ,6 ,4]

print(aplicarNotificaciones(notas))