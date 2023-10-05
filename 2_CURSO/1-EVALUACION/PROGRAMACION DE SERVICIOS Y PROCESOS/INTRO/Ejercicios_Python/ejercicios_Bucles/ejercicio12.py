frase = input("Introduce una frase: ")
letra = input("Introduce una letra: ")
cont = 0
for palabra in frase:
    for letra2 in palabra:
        if letra == letra2:
            cont+=1

print(f"La letra {letra} aparece {cont} veces en la frase.")