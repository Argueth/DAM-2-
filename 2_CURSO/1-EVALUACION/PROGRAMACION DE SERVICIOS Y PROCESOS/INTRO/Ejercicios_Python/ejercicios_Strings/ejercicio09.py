fecha = input("Introduce tu fecha de nacimiento en formato dd/mm/aaaa: ")

print(f"Dia: {fecha[:2]} - Mes: {fecha[3:5]} - Año: {fecha[6:]}")

partes = list(fecha.split("/"))

print(f"Día: {partes[0]} - Mes: {partes[1]} - Año: {partes[2]}")