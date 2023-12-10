#!/usr/bin/python3
#-*-coding: utf-8-*-

num = int(input())
pasillos = int(input())
estanterias = int(input())
baldas = int(input())
compartimentos = int(input())

for pasillo in range(pasillos):
    for estanteria in range(estanterias):
        for balda in range(baldas):
            huecos = 0
            for compartimento in range(compartimentos):
                datos = list(map(int, input().split(" ")))
                if len(datos)>1:
                    huecos += (datos[1] - datos[0])
            print(f"P {pasillo:02} E {estanteria:02} {balda:03} {huecos:03} {'SI' if huecos > num else 'NO'}")
