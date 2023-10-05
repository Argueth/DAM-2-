facturas = {}
pendiente = 0
cobrado = 0
continuar = ""
while continuar != 'T':
    if continuar == 'A':
        clave = input("Introduce el número de factura: ")
        valor = float(input("Introduce el coste de la factura: "))
        facturas[clave] = valor
        pendiente += valor
    elif continuar == 'P':
        num = input("Introduce el número de factura: ")
        coste = facturas.pop(num, 0)
        cobrado += coste
        pendiente -= coste
    print(f"Recaudado: {round(cobrado, 2)}")
    print(f"Pendiente: {round(pendiente, 2)}")
    continuar = input(("Desea añadir una nueva factura(A), pagarla(P) o terminar(T)")).capitalize()

print("Adiós")

