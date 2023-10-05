n = int(input("Introduce un número entero positivo: "))

for i in range(2, n):
    if n%i != 0:
        break

if (i+1) == n:
    print("El número es primo.")
else:
    print("El número no es primo.")
      