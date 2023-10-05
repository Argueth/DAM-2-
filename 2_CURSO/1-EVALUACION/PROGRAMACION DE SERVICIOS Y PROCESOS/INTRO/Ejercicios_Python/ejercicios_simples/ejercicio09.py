capital = float(input("Introduce la cantidad a invertir: "))
interes = float(input("Introduce el interés anual: "))
numAños = int(input("Introduce el número de años: "))

print(f"El capital obtenido es {round((((capital*interes)/100)*numAños)+capital, 2)}€")