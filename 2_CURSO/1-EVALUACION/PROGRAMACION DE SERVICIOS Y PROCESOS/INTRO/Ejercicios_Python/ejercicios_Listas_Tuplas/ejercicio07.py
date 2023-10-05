alfabeto = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
letrasEliminadas = []

for i, letra in enumerate(alfabeto):
    if (i+1)%3 == 0:
        letrasEliminadas.append(letra)

for letra in letrasEliminadas:
    if letra in alfabeto:
        alfabeto.remove(letra)

print(alfabeto)