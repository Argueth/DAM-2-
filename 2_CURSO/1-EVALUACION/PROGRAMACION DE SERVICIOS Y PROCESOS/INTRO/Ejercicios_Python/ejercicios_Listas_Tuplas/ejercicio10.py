precios = [50, 75, 46, 22, 80, 65, 8]

menor = sorted(precios)
mayor = sorted(precios, reverse=True)

print(f"El mayor precio es {mayor[0]} y el menor es {menor[0]}")