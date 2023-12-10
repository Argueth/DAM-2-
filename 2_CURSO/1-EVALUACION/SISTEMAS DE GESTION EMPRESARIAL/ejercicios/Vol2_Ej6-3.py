#!/usr/bin/python3
#-*-conding: utf-8-*-

num_casos = int(input())

for caso in range(num_casos):
    longitud = 0
    piezas = []
    
    for i in range(1,6):
        long_pieza = int(input())
        piezas.extend([i] * long_pieza)
    
    piezas.sort(reverse=True)
    hay_1 = any(pieza == 1 for pieza in piezas)
    piezas_sin_1 = [pieza for pieza in piezas if pieza != 1]
    num_piezas = len(piezas_sin_1)
    if num_piezas % 2 != 0:
        for i in range((num_piezas//2)+1):
            longitud += piezas[i]
    else:
        for i in range(num_piezas//2):
            longitud += piezas[i]
        if hay_1:
            longitud+=1
        
    print(f"Caso: {caso} -- Hay 1: {'SI' if hay_1 else 'NO'} -- Piezas: {piezas} -- Longitud Máxima de la fila: {longitud}")