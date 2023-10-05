def crearDiccionario(frase):
    return {palabra:len(palabra) for palabra in frase.split(" ")}

print(crearDiccionario("Vete a la mierda"))