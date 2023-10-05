def crearDiccionario(frase):
    palabras = frase.split(" ")
    longitudes = map(len,palabras)
    return dict(zip(palabras,longitudes))

print(crearDiccionario("Vete a la mierda"))