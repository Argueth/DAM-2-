#!/usr/bin/python3
#-*-conding: utf-8-*-

num_casos = int(input())

for caso in range(num_casos):
    longitud = 0
    piezas = {}
    
    for i in range(1,6):
        piezas[i] = int(input())
        
    piezas = {clave : valor for clave, valor in piezas.items() if valor != 0}
    cant_piezas = sum(piezas.values())
    bloques = 0
    
    for longitud, cantidad in piezas.items():
        bloques += longitud * cantidad
    
    print(f"Caso: {caso} -- Bloques: {bloques} -- Cantidad piezas: {cant_piezas} Piezas: {piezas}")