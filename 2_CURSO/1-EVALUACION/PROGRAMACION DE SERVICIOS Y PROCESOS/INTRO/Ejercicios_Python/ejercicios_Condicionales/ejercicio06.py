gen = input("Introduce tu sexo h/m: ")
nombre = input("Introduce tu nombre: ")

if ((gen == 'm' and nombre[0].lower() <= 'm') or (gen == 'h' and nombre[0].lower() >= 'n')):
    print("Te toca el grupo A")
else:
    print("Te toca el grupo B")