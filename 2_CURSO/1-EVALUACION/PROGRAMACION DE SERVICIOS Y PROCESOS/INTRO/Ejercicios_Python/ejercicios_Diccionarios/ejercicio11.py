cadena = "nif;nombre;email;teléfono;descuento\n01234567L;Luis González;luisgonzalez@mail.com;656343576;12.5\n71476342J;Macarena Ramírez;macarena@mail.com;692839321;8\n63823376M;Juan José Martínez;juanjo@mail.com;664888233;5.2\n98376547F;Carmen Sánchez;carmen@mail.com;667677855;15.7"
lineas = cadena.split("\n")
campos = lineas[0].split(";")

clientes = {}

for i in lineas[1:]:
    cliente = {}
    datos = i.split(";")
    nif = datos[0]

    for j in range(1, len(campos)):
        nombre_campo = campos[j]
        valor_campo = datos[j]
        cliente[nombre_campo] = valor_campo
    
    cliente['descuento'] = float(cliente['descuento'])

    clientes[nif] = cliente


for nif, datos in clientes.items():
    print(f"NIF: {nif}")
    for campo, valor in datos.items():
        print(f"{campo}: {valor}")
    print()
