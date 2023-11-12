#!/usr/bin/python3
# -*- coding: utf-8 -*-

numeroDeSeries = int(input())
diccionario = {}

for _ in range(numeroDeSeries):
    serie = input()
    datosSerie = serie.split(",")
    codigo = datosSerie[0]
    print(codigo)
    numeros = datosSerie[1:len(datosSerie)]
    print(numeros)
    diccionario[codigo] = numeros

print(diccionario)

