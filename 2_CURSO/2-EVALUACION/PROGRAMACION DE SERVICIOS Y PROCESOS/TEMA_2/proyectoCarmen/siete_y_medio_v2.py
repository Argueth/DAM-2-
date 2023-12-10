import random


def ver_menu():
    """La función ver_menu es la salida del menu por pantalla para poder elegir, una vez introducida la opción que deseamos,
    Nos redirije a la función correspondiente."""
    salida = False
    ganador = []

    while not salida:
        print("""
                     7 Y MEDIO
    ***************************************
        1 - JUGAR PARTIDA
        2 - RESUMEN PARTIDA
        3 - SALIR DEL JUEGO
    ***************************************
                """)
        opcion = opcion_elegida()
        if opcion == 1:
            jugador = jugar_partida()
            if jugador is not None:
                adios_partida(jugador, ganador)
        elif opcion == 2:
            resumen_partida(ganador)
        elif opcion == 3:
            print("\nGracias por jugar conmigo, espero volver a verte.\n")
            salida = True

def opcion_elegida():
    """Esta función es para controlar que lo que entre por pantalla sea lo que se pide, en este caso un número del 1 al 3
    dependiendo de lo que queramos hacer."""
    valido = False

    while not valido:
        try:
            opcion = int(input("Dime tu elección: \n"))
            if 0 < opcion < 4:
                valido = True
        except ValueError:
            print(f"Opción no válida, introduzca un número del 1 al 3")
    return opcion

def jugar_partida():
    """Esta función nos realiza un random para elegir una 'carta' y en el caso de que sea el 10, 11 u 12,
    estas valdrán 0.5 puntos, el resto tendrán como valor el número que sale. Luego hace una selección a la función que tiene que ii
    dependiendo del valor de la global jugador que es la suma total de las jugadas."""
    
    jugador = 0

    while jugador < 7.5:
        jugada = random.choice([1, 2, 3, 4, 5, 6, 7, 10, 11, 12])
        if jugada == 10 or jugada == 11 or jugada == 12:
            jugada = 0.5
        jugador += jugada
        print("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")
        print("             CARTAS EN LA MESA                   ")
        print("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")
        print(f"El croupier te da tu carta, es un {jugada}")
        print(f"En total de tus jugadas es {jugador}")
        print("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n")

        if jugador >= 7.5:
            return jugador
        elif jugador < 7.5:
            respuesta = nueva_jugada()
            if respuesta == "n":
                return jugador

def nueva_jugada():
    """Esta función lo que hace es preguntar al usuario si desea una nueva carta o no, dependiendo de la respuesta,
    nos llevará a una función u otra.""" 
    while True:
        try:
            respuesta = input("""
                                \n¿Quieres una carta más?
                                    Si --> s
                                    No --> n\n
                                        """)
            if respuesta == "s" or respuesta == "n":
                return respuesta
            else:
                print("Opción no válida")
        except:
            print("Por favor introduzca una respuesta válida n / s")


def adios_partida(jugador, ganador):
    """Esta función es para determinar que ha ocurrido en el juego y dependiendo de la variable jugador nos dará un resultado u otro.
    Además, hay creada la variable ganador para guardar la información de cada partida."""  

    if jugador <= 6:
        print(f"¿En serio te has plantado con {jugador} puntos? Menudo rajadoooooo")
        ganador.append(f"Rajaooooooooo -> {jugador}")
    elif 6 < jugador < 7.5:
        print(f"No está mal, pero el que no arriesga no gana, te quedas con {jugador} puntos, muy cerca")
        ganador.append(f"pichi-picha -> {jugador}")
    elif jugador == 7.5:
        print(f"Eres un gran jugador, ¡¡¡¡Has ganado!!!!")
        ganador.append(f"Maquinaaaaaaaaaaa -> {jugador}")
    elif jugador > 7.5:
        print("Mal jugado, ¡¡¡¡Has perdido!!!!")
        ganador.append(f"Loser -> {jugador}")

def resumen_partida(ganador):
    """Esta función nos imprime el resultado de todas las partidas realizadas."""

    print("""
          *-*-*-*-*-*-*-*-*-*-*-*-*
             RESUMEN DE PARTIDAS
          *-*-*-*-*-*-*-*-*-*-*-*-*
          """)
    print("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")
    for i, partida in enumerate(ganador):
        
        print(f"        Partida {i + 1}: {partida}")
    print("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")

if __name__ == "__main__":
    """El main da la bienvenida al ususario y nos lleva directamente a la función ver_menu"""
    
    print("""
          *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
            Bienvenid@ al juego 7 y medio
          *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
          """)
    ver_menu()
