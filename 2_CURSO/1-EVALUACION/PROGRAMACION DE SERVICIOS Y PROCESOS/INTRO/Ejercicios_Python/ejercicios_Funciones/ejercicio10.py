def convertirBinario(num):
    binario = ""
    if num == 0:
        return 0
    
    while num > 0:
        digito = num%2
        num//=2
        binario+=str(digito)
    return binario

def convertirDecimal(num):
    decimal = 0
    num = str(num)
    longitud = len(num)

    for i, digito in enumerate(num):
        if digito == '1':
            decimal += 2**(longitud-1-i)
    
    return decimal

print(convertirBinario(10))
print(convertirDecimal(1010))