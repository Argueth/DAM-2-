print("1 - Menú Vegetariano\n2 - Menú no Vegetariano")
eleccion = int(input("Introduzca el número correcpondiente al menú escogido: "))

if eleccion == 1:
    pizza = "Vegetariana"
    print("Ingredientes a escoger:\n1 - Pimiento\n2 - Tofu")
    eleccion2 = int(input("Introduzca le número correspondiente al ingrediente escogido: "))
    if eleccion2 == 1:
        ingrediente = "Pimiento"
    elif eleccion2 == 2:
        ingrediente = "Tofu"
    else:
        ingrediente = "ERROR"
        print("ERROR. Opción no disponible.")
elif eleccion == 2:
    pizza = "No Vegetariana"
    print("Ingredientes a escoger:\n1 - Peperoni\n2 - Jamón\n3 - Salmón")
    eleccion2 = int(input("Introduzca el número correspondiente al ingrediente escogifo: "))
    if eleccion2 == 1:
        ingrediente = "Peperoni"
    elif eleccion2 == 2:
        ingrediente = "Jamón"
    elif eleccion2 == 3:
        ingrediente = "Salmón"
    else:
        ingrediente = "ERROR"
        print("ERROR. Opción no disponible.")
else:
    ingrediente = "ERROR"
    print("ERROR. Opción no disponible.")

if ingrediente != "ERROR":
    print(f"Menú escogido: Pizza {pizza}. Ingrediente adicional: {ingrediente}")

