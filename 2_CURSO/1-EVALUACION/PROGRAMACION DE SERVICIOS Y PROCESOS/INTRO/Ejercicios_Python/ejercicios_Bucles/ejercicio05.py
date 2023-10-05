cantidad = float(input("Introduce la cantidad a invertir: "))
interesAnual = float(input("Introduce el interés anual: "))
numAños= int(input("Introduce en número de años: "))

for i in range(numAños):
    cantidad*=(1+(interesAnual/100))
    print(f"Capital en el año {i+1}: {round(cantidad, 2)}€")


