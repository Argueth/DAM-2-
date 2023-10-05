producto = input("introduce el nombre del producto: ")
precio = float(input("Introduce el precio del producto: "))
unidades = int(input("Introduce el número de unidades del producto: "))

print(f"Nombre: {producto} - Precio: {precio:9.2f} - Unidades: {unidades:3d} - Precio Total: {(precio*unidades):11.2f}")