peso = float(input("Introduce tu peso en kilos: "))
altura = float(input("introduce tu altura en metros"))

imc = round(peso / (altura**2), 2)

print(imc)