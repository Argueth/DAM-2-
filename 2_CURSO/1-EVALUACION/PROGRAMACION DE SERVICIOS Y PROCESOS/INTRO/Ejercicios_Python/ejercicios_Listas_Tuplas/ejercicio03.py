lista = ["Matemáticas", "Física", "Química", "Historia", "Lengua"]
notas = []

for asig in lista:
    nota = input((f"Qué nota has sacado en {asig}?"))
    notas.append(nota)

for i in range(len(lista)):
    print(f"En {lista[i]} has sacado {notas[i]}")