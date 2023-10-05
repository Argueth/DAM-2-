lista = ["Matemáticas", "Física", "Química", "Historia", "Lengua"]
aprobadas = []

for asig in lista:
    nota = float(input(f"Qué nota has sacado en {asig}?"))
    if nota > 5:
        aprobadas.append(asig)

for asig in aprobadas:
    lista.remove(asig)

for asig in lista:
    print(asig)