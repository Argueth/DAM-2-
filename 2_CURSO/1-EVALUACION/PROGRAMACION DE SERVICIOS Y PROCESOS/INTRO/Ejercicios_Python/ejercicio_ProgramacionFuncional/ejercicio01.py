def aplicarDescuento(precio, porcentaje):
    return precio-(precio*(porcentaje/100))

def aplicarIVA(precio, porcentaje):
    return precio*(1+(porcentaje/100))

def aplicarPrecio(diccionario, funcion):
    precioFinal=0
    for precio, porcentaje in diccionario.items():
        precioFinal += funcion(precio,porcentaje)
    
    return round(precioFinal,2)

diccionario = {1.23:4, 4.5:4, 10:3, 100:2}
print(aplicarPrecio(diccionario,aplicarIVA))

