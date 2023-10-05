import math

def calcularMaximoComunDivisor(lista):
    mcd_actual = lista[0]

    for num in lista[1:]:
        mcs_actual = math.gcd(mcd_actual, num)
    
    return mcd_actual


def calcularMinicomComunMultiplo(lista):
    mcm_actual = lista[0]

    for num in lista[1:]:
        mcm_actual = math.lcm(mcm_actual, num)

    return mcm_actual

lista = [1, 2, 3, 4, 5, 6]

print(calcularMaximoComunDivisor(lista))
print(calcularMinicomComunMultiplo(lista))