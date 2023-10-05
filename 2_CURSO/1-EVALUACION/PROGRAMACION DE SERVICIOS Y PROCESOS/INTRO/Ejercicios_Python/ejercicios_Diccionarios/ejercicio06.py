persona = {}
seguir = True
while seguir:
    clave = input("Qué dato quieres introducir? ").capitalize()
    valor = input(f"{clave}: ").capitalize()
    persona[clave] = valor
    print(persona)
    seguir = input("Desea continuar rellenando el diccionario?(Si/No)").lower() == 'si'