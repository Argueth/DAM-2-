password = str(1234)

while(True):
    intro = input("Introduce la contraseña: ")
    if intro == password:
        print("Contraseña correcta!!")
        break
    else:
        print("Contraseña errónea, vuelva a intentarlo.")