a = ((1, 2, 3),
     (4, 5, 6))
b = ((-1, 0),
     (0, 1),
     (1, 1))

producto = [[0, 0],[0, 0]]

print(len(a))

for i in range(len(a)):
    for j in range(len(b[0])):
        for k in range(len(a[0])):
            producto[i][j] += a[i][k] * b[k][j]

print(producto)