num = input("Introduce el teléfono con formato prefijo-número-extensión: ")

separado = list(num.split("-"))

print(separado[1])