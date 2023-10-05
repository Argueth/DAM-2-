compra = {}

continuar = True

while continuar:
    clave = input("Indica el producto: ").capitalize()
    valor = input("Indica el precio: ").capitalize()
    compra[clave] = valor
    continuar = input("Desea continuar? (Si/No)").lower() == 'si'

total = 0
print("CESTA DE LA COMPRA")
for clave, valor in compra.items():
    print(f"{clave} -> {valor}€")
    total += float(valor)

print(f"Total  ->  {total}€")
