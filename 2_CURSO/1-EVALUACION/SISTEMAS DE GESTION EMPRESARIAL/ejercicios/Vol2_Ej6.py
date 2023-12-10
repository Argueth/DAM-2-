#!/usr/bin/python3
#-*-conding: utf-8-*-

num_casos = int(input())

for caso in range(num_casos):
    longitud = 0
    piezas = {}
    
    for i in range(1,6):
        piezas[i] = int(input())
        
    piezas = {clave : valor for clave, valor in piezas.items() if valor != 0}
    piezasOrdenadas = dict(sorted(piezas.items(), key = lambda item: item[0], reverse=True))
    
    num_piezas_mayores_1 = sum(valor for clave, valor in piezas.items() if clave > 1)
    num_piezas_valor_1 = sum(valor for clave, valor in piezas.items() if clave == 1)
    
            
    
    print(f"Número de piezas mayores que 1: {num_piezas_mayores_1}\nNúmero de piezas de tamaño 1: {num_piezas_valor_1}")
    print(f"Caso {caso + 1}: {piezasOrdenadas} -- Longitud: {longitud}")
