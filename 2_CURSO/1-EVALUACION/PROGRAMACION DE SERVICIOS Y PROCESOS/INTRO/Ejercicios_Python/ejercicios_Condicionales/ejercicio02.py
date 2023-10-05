password = "1234"

entrada = input("Introduce la contraseña: ")

if password.lower() == entrada.lower():
    print("Contraseña correcta.")
else:
    print("ERROR. Contraseña incorrecta.")
