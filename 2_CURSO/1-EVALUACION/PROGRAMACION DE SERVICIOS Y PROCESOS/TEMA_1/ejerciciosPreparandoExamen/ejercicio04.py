#!/usr/bin/python3
#-*-coding: utf-8-*-

from pathlib import Path

def contar(frase):
    cont = 0
    for letra in frase:
        if letra in 'aáAeéEiíIoóOuúU':
            cont += 1
    return cont

if __name__ == "__main__":
    ruta_parent = Path(__file__).parent
    vocales_totales = 0
    try:
        f1 = open(ruta_parent/"solucion.txt", "w")
    except OSError as e:
        print(f"Archivo solucion: {e}")
    else:
        try:
            f2 = open(ruta_parent/"frases.txt", "r", encoding="utf-8")
            for indice, linea in enumerate(f2.readlines()):
                num = contar(linea)
                vocales_totales += num
                print(f"La frase {indice + 1} tiene {num} vocales", file=f1)
            print(f"El total de vocales del archivo es: {vocales_totales}", file=f1)
        except OSError as e:
            print(f"Archivo frases: {e}")