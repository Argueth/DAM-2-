meses = {1:'Enero', 2:'Febrero', 3:'Marzo', 4:'Abril', 5:'Mayo', 6:'Junio', 7:'Julio', 8:'Agosto', 9:'Septiembre', 10:'Octubre', 11:'Noviembre', 12:'Diciembre'}

fecha = input("Introduce la fecha deseada (dd/mm/aaaa): ")

fecha = fecha.split("/")

print(f"{fecha[0]} de {meses[int(fecha[1])]} de {fecha[2]}")
