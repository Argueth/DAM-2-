dict = {}

entrada = input("Introduce la palabra en español seguida de : y su traducción. Separa cada par con una coma.")

pares = entrada.split(",")

for par in pares:
    palabras = par.split(":")
    dict[palabras[0]] = palabras[1]

frase = input("Introduce una frase para traducir: ")

palabrasFrase = frase.split(" ")
fraseTraducida = ""
for palabra in palabrasFrase:
    if palabra in dict:
        fraseTraducida += (dict[palabra] + " ")
    else:
        fraseTraducida += (palabra + " ")

print(fraseTraducida.capitalize())