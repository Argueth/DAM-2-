productos = input("Introduce la lista de productos separados por una coma: ")

lista = list(productos.split(","))

for producto in lista:
    print(producto)