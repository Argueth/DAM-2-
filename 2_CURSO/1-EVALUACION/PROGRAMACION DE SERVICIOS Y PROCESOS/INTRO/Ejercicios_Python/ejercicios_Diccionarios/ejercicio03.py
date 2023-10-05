fruteria = {'Platano':1.35, 'Manzana':0.80, 'Pera':0.85, 'Naranja':0.70}

fruta = input("Introduce la fruta en la que estás interesado: ")

if fruta.capitalize() not in fruteria:
    print("En la frutería no está esa fruta.")
    exit

kilos = float(input("Introduce el número de kilos que quieres de la fruta: "))

print(f"El precio de {kilos} de {fruta} es de {round(fruteria[fruta.capitalize()]*kilos, 2)}€")