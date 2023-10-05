n = [1, 2, 3]
m = [-1, 0, 2]
productoEscalar= 0

for i, valorN in enumerate(n):
    productoEscalar += valorN * m[i]

print(productoEscalar)