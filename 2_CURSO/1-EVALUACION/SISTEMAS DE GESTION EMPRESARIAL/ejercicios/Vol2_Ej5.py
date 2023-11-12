#!/usr/bin/python3
#-*-conding: utf-8-*-

from functools import reduce

entrada = input()

listaNumeros = list(map(int, entrada.split(",")))

media = reduce(lambda a,b: a+b, listaNumeros)/len(listaNumeros)

binomioCuadrado = list(map(lambda a: (a-media)**2, listaNumeros))

sumatorio = reduce(lambda x,y:x+y, binomioCuadrado)

desviacionTipica = (sumatorio / len(listaNumeros))**0.5

print(f"Media: {media:.4f}")

print(f"Binomio al cuadrado: {binomioCuadrado}")

print(f"Desviación Típica: {desviacionTipica:.4f}")
