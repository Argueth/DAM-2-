lista = []

while(True):
    n = input("Introduce el número ganador de la loteria: ")
    if n == "ya":
        break
    else:
        lista.append(int(n))

lista.sort()
print("Los número ganadores son: ", end="")
for num in lista:
    print(num, end=" ")