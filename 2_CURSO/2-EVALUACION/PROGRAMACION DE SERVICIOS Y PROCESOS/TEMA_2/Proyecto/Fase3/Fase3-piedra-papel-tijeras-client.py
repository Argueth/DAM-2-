import socket
import sys

#Declaración de variables globales.
socket_client = None #Socket que después crearé.
HOST = '127.0.0.1' #IP
PORT = 5000 #Número de puerto.

def init_client():
    """Función para al creación del socket."""
    global socket_client
    try:
        socket_client = socket.socket(socket.AF_INET, socket.SOCK_STREAM) #Creación del socket.
        print("Socket cliente creado.")
    except socket.error:
        print("Error al crear el socket cliente.")
        sys.exit()
        
    socket_client.connect((HOST, PORT)) #Conexión del socket con una dirección ip y un número de puerto (el servidor.)

def recieve_data():
    """Función para recibir información del servidor y decodificarla."""
    return socket_client.recv(1024).decode()

def send_data(msg):
    """Función para enviar información al servidor ya codificada a binario."""
    socket_client.sendall(msg.encode())


def start_menu():
    """Función para mostrar el menú de inicio y gestionar las distintas opciones que puede elegir el usuario."""
    #Declaración de variables. 
    salir = False
    option = -1
    #Bucle para seguir con el juego hasta que el usuario decida salir del programa. 
    while not salir:
        print("""
    MENÚ DE JUEGO
======================================
    1 - Jugar una partida
    2 - Ver resumen de partidas
    0 - Salir
======================================
            """)
        option = check_option(0, 2) #Recibo la opción desde la función de comprobación.
        if option == 1:
            send_data(str(option)) #Envío la opción escogida por el usuario.
            play_game() #Me muevo a la función play_game para mostrar al usuario el menú con las opciones para las rondas. 
        elif option == 2:
            send_data(str(option)) #Envío al servidor la opción escogida por el jugador
            print(recieve_data()) #Recibo e imprimo la respuesta del servidor.
        elif option == 0:
            print("\nAdiós!!!!\n") 
            send_data(str(option)) #Envío al servidor la opción del usuario.
            salir = True #Activo la condición de salida del bucle.
    socket_client.close() #Cierro el socket.

def check_option(min, max):
    """Método para pedir al usuario la opción escogida y comprobar que es válida."""
    while True:
        try:
            option = int(input("Introduce el número de la opción deseada: -->"))
            if min <= option <= max:
                return option
            else:
                print(f"\nOpción no válida. Por favor, introduce un número entre {min} y {max}\n") 
        except ValueError:
            print(f"\nPor favor, introduce un entero entre {min} y {max}.\n")

def play_game():
    """Método para gestionar la partida"""
    end_game = False #Condición de salida de la partida.
    while not end_game:
        show_game_menu() #Muestro el menú de las opciones de cada ronda.
        send_data(str(check_option(1,3))) #Envío la opción (ya validada) escogida por el usuario al servidor.
        #Recibo el mensaje con las puntuaciones y el resultado de la ronda y lo espliteo.
        player_score, computer_score, round_result = recieve_data().split(',') 
        print(f"\n{round_result}\n") #Muestro el resultado de la ronda.
        #Condicional para, dependiendo de las puntuaciones, salir de la partida y volver al menú inicial del juego.
        if int(player_score) == 3 or int(computer_score) == 3:
            end_game = True
        #Muestro el resultado de la ronda.
        print(f"PLAYER SCORE: {player_score}\nCOMPUTER SCORE: {computer_score}\n")
        #Si las dos puntuaciones son menores de 3 le pido al usuario que pulser ENTER para continuar.
        #De este modo el usuario puede ver mejor el resultado de la ronda.
        if int(player_score) < 3 and int(computer_score) < 3:
            input("\nPress ENTER to continue.\n")
    
    #Imprimo el resumen de la partida enviada por el servidor.         
    print(recieve_data())
    input("\nPress ENTER to continue.\n")

def show_game_menu():
    """Método para mostrar el menú de opciones de juego dentro de una partida."""
    print("""
  ¿¿QUÉ JUGARÁS??
===============================
1 - Piedra
2 - Papel
3 - Tijeras
===============================
          """)

if __name__ == "__main__":
    init_client()
    print("\nBienvenido a...\n¡¡¡¡¡PIEDRA, PAPEL O TIJERAS!!!!!")
    start_menu()