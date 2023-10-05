def calcularIVA(cantidad, porcentajeIVA = 21):
    return (cantidad * (1 + (porcentajeIVA/100)))

print(round(calcularIVA(1000), 2))