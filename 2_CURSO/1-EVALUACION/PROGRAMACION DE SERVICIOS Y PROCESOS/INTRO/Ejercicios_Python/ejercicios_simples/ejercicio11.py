cantidadInicial = float(input("Introduce la cantidad de saldo de tu cuenta: "))

for i in range(1, 4):
    cantidadInicial *= 1.04
    print(f"El saldo al final del año {i} es de {round(cantidadInicial, 2)}€")