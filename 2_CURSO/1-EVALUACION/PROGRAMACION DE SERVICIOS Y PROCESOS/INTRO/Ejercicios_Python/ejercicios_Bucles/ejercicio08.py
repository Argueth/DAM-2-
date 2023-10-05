n = int(input("Introduce un número entero positivo: "))

altura = 1
for i in range(1, n+1):
    for j in range(altura, 0, -2):
        print(j, end=" ")
    print("")
    altura+=2