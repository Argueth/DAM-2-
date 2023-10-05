inmuebles = [{'año': 2000, 'metros': 100, 'habitaciones': 3, 'garaje': True, 'zona': 'A'},
{'año': 2012, 'metros': 60, 'habitaciones': 2, 'garaje': True, 'zona': 'B'},
{'año': 1980, 'metros': 120, 'habitaciones': 4, 'garaje': False, 'zona': 'A'},
{'año': 2005, 'metros': 75, 'habitaciones': 3, 'garaje': True, 'zona': 'B'},
{'año': 2015, 'metros': 90, 'habitaciones': 2, 'garaje': False, 'zona': 'A'}]

def añadirPrecio(piso):
    validos = ()
    precio = (piso['metros'] * 100 + piso['habitaciones']*5000 + int(piso['garaje']) * 15000) * (1 - (2023-piso['año'])/100)
    if piso['zona'] == 'B':
            precio *= 1.5
    piso['precio'] = round(precio, 2)
      
    return piso

def buscaPiso(lista, presupuesto):
      def filtro(piso):
            return piso['precio'] <= presupuesto
      
      return list(filter(filtro, map(añadirPrecio, lista)))

for piso in buscaPiso(inmuebles, 100000):
    for key, value in piso.items():
        print(f"{key.capitalize()}: {value}")
    print()
    