listaUsuario = input("Introduce una serie de números separados por comas: ")

lista = list(listaUsuario.split(","))

lista_enteros = [int(x) for x in lista]

print(f"La media de la lista es: {sum(lista_enteros)/len(lista_enteros)}")

