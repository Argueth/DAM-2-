num = int(input("Introduce el número de pisos que quieres para tu pirámide: "))

for i in range(num):
    for j in range(i):
        print("*", end="")
    print("")

for i in range(num):
    print("*"*(i+1))