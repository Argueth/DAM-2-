lista = []

for i in range(1, 11):
    lista.append(i)

#--------------------------------------
#Otro modo
for i in lista:
    print(lista[-i], end=", ")
print("")
#--------------------------------------

lista.sort(reverse=True) #También se puede hacer con lista.reverse()

for i in lista:
    print(i, end=", ")