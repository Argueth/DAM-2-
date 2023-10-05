numBarras = int(input("Introduce el número de barras de pan que no son del día: "))

precioBarra = 3.49
precioDescuento = precioBarra*0.40

print(f"Precio normal de Barra de Pan: {precioBarra}")
print(f"Descuento por no ser del día: {round(precioBarra-precioDescuento, 2)}")
print(f"Coste final de las barras solicitadas: {round(numBarras*precioDescuento,2)}")