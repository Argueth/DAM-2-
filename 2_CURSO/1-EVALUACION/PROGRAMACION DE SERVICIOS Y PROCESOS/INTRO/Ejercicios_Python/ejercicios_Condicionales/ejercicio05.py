age = int(input("Introduce tu edad: "))
ingresos = float(input("Introduce tus ingresos anuales: "))

if age > 16 and ingresos >= 1000:
    print("Debes tributar.")
else:
    print("No tienes que tributar.")