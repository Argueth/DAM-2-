bonificacion = 2400

puntuacion = float(input("Introduce la puntuación del empleado: "))

if puntuacion == 0.0:
    nivel = "Inaceptable"
elif puntuacion == 0.4:
    nivel = "Aceptable"
elif puntuacion == 0.6:
    nivel = "Meritorio"
else:
    nivel = ""

if nivel != "":
    print(f"Tu nivel es {nivel}. Tu bonificación es de {(2400 * puntuacion):.2f}")

