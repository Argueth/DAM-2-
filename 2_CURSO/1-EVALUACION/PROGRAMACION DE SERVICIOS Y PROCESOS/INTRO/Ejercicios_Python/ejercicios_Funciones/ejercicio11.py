def frecuenciarPalabras(cadena):
    diccionario = {}
    palabras = cadena.split(" ")
    for palabra in palabras:
        if palabra in diccionario:
            diccionario[palabra]+=1
        else:
            diccionario[palabra]=1
    return diccionario

cadena = input("Introduce una frase: ")

diccionario = frecuenciarPalabras(cadena)

for clave, valor in diccionario.items():
    print(f"{clave.capitalize()}: {valor}")