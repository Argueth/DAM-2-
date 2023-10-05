palabra = input("Introduce una palabra: ")

palabraDelReves = palabra[::-1]

if palabra == palabraDelReves:
    print(f"{palabra} es un palíndromo.")
else:
    print(f"{palabra} no es un palíndromo")