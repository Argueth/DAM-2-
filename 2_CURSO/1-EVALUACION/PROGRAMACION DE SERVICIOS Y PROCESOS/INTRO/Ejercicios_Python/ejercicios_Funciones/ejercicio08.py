import statistics

def calcularDiccionario(lista):
    media = sum(lista)/len(lista)
    varianza = statistics.variance(lista)
    desviacionTipica = statistics.stdev(lista)

    return {'Media':media, 'Varianza':varianza, 'Desviación Típica':desviacionTipica}

lista = [1, 2, 3, 4, 5, 6]

diccionario = calcularDiccionario(lista)

for clave, valor in diccionario.items():
    print(f"{clave}: {round(valor, 2)}")
