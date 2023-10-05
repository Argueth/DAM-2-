palabra = input("Introduce una palabra: ")
vocales = ['a', 'e', 'i', 'o', 'u']

for vocal in vocales:
    rep = 0
    for letra in palabra:
        if letra == vocal:
            rep += 1
    if rep != 0:
        print(f"La vocal {vocal} se repite {rep} veces en la palabra {palabra}")
