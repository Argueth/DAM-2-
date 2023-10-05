renta = float(input("Introduce tu renta anual: "))

if renta < 1000:
    tipo = 5
elif renta < 20000:
    tipo = 15
elif renta < 35000:
    tipo = 20
elif renta < 60000:
    tipo = 30
else:
    tipo = 45

print(f"Tienes que pagar un interés del {tipo}% - {renta * (tipo/100)}€")
