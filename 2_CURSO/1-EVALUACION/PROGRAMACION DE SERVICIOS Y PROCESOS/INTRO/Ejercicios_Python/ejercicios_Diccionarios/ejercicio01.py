dict = {"Euro":"€", "Dollar":"$", "Yen":"¥"}

divisa = input("Introduce la divida cuyo símbolo quieres ver: ")

if divisa.capitalize() in dict:
    print(dict[divisa.capitalize()])
else:
    print("La divisa no se encuentra en el diccionario.")