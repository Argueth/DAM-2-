def mostrarMenu():
    print("ELIGE UNA OPCIÓN: ")
    print("1.- Añadir cliente")
    print("2.- Eliminar cliente")
    print("3.- Mostrar cliente")
    print("4.- Listar todos los clientes")
    print("5.- Listar clientes preferentes")
    print("6.- Terminar")

def añadirCliente():
    nif = input("Introduce el nif del cliente: ")
    nombre = input("Introduce el nombre del cliente: ")
    direccion = input("Introduce la dirección del cliente: ")
    telefono = input("Introduce el telefono del cliente: ")
    email = input("Introduce el email del cliente: ")
    vip = input("Es un cliente preferente?(s/n)")

    cliente = {'nombre':nombre, 'direccion':direccion, 'telefono':telefono, 'email':email, 'preferente':vip}
    clientes[nif] = cliente

def eliminarCliente():
    nif = input("Introduce el nif del cliente: ")
    if nif in clientes:
        del clientes[nif]
    else:
        print("No existe ningún cliente con ese nif.")

def mostrarCliente():
    nif = input("Introduce el nif del cliente: ")
    if nif in clientes:
        print(f"NIF: {nif}")
        for clave, valor in clientes[nif].items():
            print(f"{clave.capitalize()}: {valor}")
    else:
        print("No existe ningún cliente con ese nif.")

def listarClientes():
    print("LISTA DE CLIENTES")
    for clave, valor in clientes.items():
        print(f"{clave}: {valor['nombre']}")

def listarClientesPreferentes():
    print("LISTA DE CLIENTES PREFERENTES")
    for clave, valor in clientes.items():
        if valor['preferente'].lower() == 's':
            print(f"{clave}: {valor['nombre']}")

clientes = {}
while True:
    mostrarMenu()
    opcion = int(input("-> "))
    
    if opcion == 1:
        añadirCliente()
    elif opcion == 2:
        eliminarCliente()
    elif opcion == 3:
        mostrarCliente()
    elif opcion == 4:
        listarClientes()
    elif opcion == 5:
        listarClientesPreferentes()
    elif opcion == 6:
        print("Adiós!!")
        break
    else:
        print("Opción no válida. Vuelve a intentarlo")





