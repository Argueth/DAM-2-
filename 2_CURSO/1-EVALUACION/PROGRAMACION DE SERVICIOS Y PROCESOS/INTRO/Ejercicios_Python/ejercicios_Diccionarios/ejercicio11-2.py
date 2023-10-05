cadena = "nif;nombre;email;teléfono;descuento\n01234567L;Luis González;luisgonzalez@mail.com;656343576;12.5\n71476342J;Macarena Ramírez;macarena@mail.com;692839321;8\n63823376M;Juan José Martínez;juanjo@mail.com;664888233;5.2\n98376547F;Carmen Sánchez;carmen@mail.com;667677855;15.7"
lineas = cadena.split("\n")
campos = lineas[0].split(";")

clientes = {}
for linea in lineas[1:]:
    cliente = {}
    datos = linea.split(";")
    nif = datos[0]

    for j in range(1, len(datos)):
        nombre_campo = campos[j]
        dato_campo = datos[j]
        cliente[nombre_campo] = dato_campo

    cliente['descuento'] = float(cliente['descuento'])
    clientes[nif]=cliente

for nif, datos in clientes.items():
    print(f"NIF: {nif}")
    for nombre, dato in datos.items():
        print(f"{nombre.capitalize()}: {dato}")
    print()

