import random

#Declaración de las variables globales.
games_summary = []

#Método que muestra el menú de inicio y gestiona la opción elegida por el usuario.
def start_menu():
    salir = False #Variable para salir del bucle.
    while not salir: #Bucle para mostrar el menú despuésde cada partida.
        print("""
    MENÚ DE JUEGO
======================================
    1 - Jugar una partida
    2 - Ver resumen de partidas
    3 - Salir
======================================
            """)
        option = check_option(1, 3) #Recepción de la opción ya validada.
        if option == 1:
            play_game() #Iniciar una partida
        elif option == 2:
            show_summary() #Ver el resumen de las partidas jugadas.
        elif option == 3:
            print("\nAdiós!!!!\n") #Despedida.
            salir = True #Activación de la condición de salida.

#Método para pedir al usuario una opción entre un min y un max y comprobar que es correcta. 
#Si no es válida se le vuelve a pedir.
def check_option(min, max):
    while True:
        try:
            option = int(input("Introduce el número de la opción deseada: -->"))
            if min <= option <= max: #Condición para comprobar que la opción escogida está entre las opciones posibles.
                return option #El bucle termina en el momento en que la opción es válida.
            else:
                #Mensaje de error para guiar al usuario en la elección de una opción válida.
                print(f"\nOpción no válida. Por favor, introduce un número entre {min} y {max}\n") 
        except ValueError:
            #Mensaje de error para indicar al usuario que introduzca un número entero y no un decimal o un caracter.
            print(f"\nPor favor, introduce un entero entre {min} y {max}.\n")

#Método para gestionar una partida.
def play_game():
    winers = [] #Lista para guardar los ganadores de cada ronda de la partida.
    player_score = 0 #Puntuación del jugador.
    computer_score = 0 #Puntuación del ordenador.
    #Bucle para que la partida no termine mientras la puntuación de uno de los jugadores no llegue a 3.
    while player_score < 3 and computer_score < 3: 
        show_game_menu() #Se muestra el menú con las opciones de juego.
        player_option = check_option(1, 3) #Se recoge la opción escogida por el usuario ya validada.
        computer_option = random.choice([1, 2, 3]) #Se escoge la opción del ordenador mediante un random.
        
        result = check_round_winner(player_option, computer_option) #Se dirime el ganador de la ronda y se recoge el mensaje indicador.
        print(result) #Se imprime el resultado de la ronda.
        winers.append(result) #Se añade el resultado de la ronda a la lista.
        
        #Se modifica el contador de la partida con el resultado de la ronda.
        if "WINNER -> PLAYER" in result:
            player_score += 1
        elif "WINNER -> COMPUTER" in result:
            computer_score += 1
        
        print(f"PLAYER SCORE: {player_score}\nCOMPUTER SCORE: {computer_score}") #Se muestran los contadores de la partida.
        
        #Si nadie a ganador todavía se espera el enter del usuario para continuar con la partida.
        #De este modo, el usuario puede leer el resultado de manera cómoda.
        if player_score < 3 and computer_score < 3:
            input("\nPress ENTER to continue.\n")
    
    #Se muestra el resumen de la partida con los resultados de todas las rondas. 
    show_game_summary(winers, player_score, computer_score)

#Método para comprobar el ganador de una ronda.
def check_round_winner(player_option, computer_option):
    #Lista de opciones. De este modo el usuario puede meter solo un número y no una palabra.
    #Creo que, de este modo, se minimizan las posibilidades de error por parte del usuario y, por tanto, se agiliza el juego.
    options = ["Piedra", "Papel", "Tijeras"]
    #Diccionario para almacenar los posibles resultados.
    result_matrix = {
        (1, 1): "EMPATE",
        (1, 2): "WINNER -> COMPUTER",
        (1, 3): "WINNER -> PLAYER",
        (2, 1): "WINNER -> PLAYER",
        (2, 2): "EMPATE",
        (2, 3): "WINNER -> COMPUTER",
        (3, 1): "WINNER -> COMPUTER",
        (3, 2): "WINNER -> PLAYER",
        (3, 3): "EMPATE",
    }

    player_choice = options[player_option - 1] #Se almacena la opción del jugador
    computer_choice = options[computer_option - 1] #Se almacena la opción del ordenador.
    result_key = (player_option, computer_option) #Dupla con el resultado recibido como parámetro

    return f"PLAYER -> {player_choice} -- COMPUTER -> {computer_choice} -- {result_matrix[result_key]}"

#Método para mostrar el resumen de la partida.   
def show_game_summary(winers, player_score, computer_score):    
    print("\nGAME SUMMARY") #Se muestra el rótulo del resumen.
    #Se recorre la lista de rondas para mostrar el resultado de cada una.
    for i, result in enumerate(winers):
        print(f"Game {i+1}: {result}")
    
    #Se añade el resultado de la partida a la lista de partidas.
    if player_score == 3:
        games_summary.append("WINER -> PLAYER")
        print("\nWINER -> PLAYER\n")
    elif computer_score == 3:
        games_summary.append("WINER -> COMPUTER")
        print("\nWINER -> COMPUTER\n")

    #Se espera el enter del usuario para que pueda ver bien el listado de resultados.
    input("\nPress ENTER to continue.\n")

#Método para mostrar el menú de opciones de juego.
def show_game_menu():
    print("""
  ¿¿QUÉ JUGARÁS??
===============================
1 - Piedra
2 - Papel
3 - Tijeras
===============================
          """)
    
def show_summary():
    if len(games_summary) < 1:
        print("\nNo hay partidas almacenadas.")
    else:
        for i, game in enumerate(games_summary):
            print(f"GAME {i+1}: {game}")
    
    input("\nPress ENTER to continue.\n")

if __name__ =="__main__":
    
    print("\nBienvenido a...\n¡¡¡¡¡PIEDRA, PAPEL O TIJERAS!!!!!")
    start_menu()