import socket
import sys
import threading
import time

def handle_client(socket_client, addr_client):
    with socket_client:
        print(f"Conexión con el cliente {addr_client}") #Mensaje informativo en la consola del servidor para indicar una nueva conexión y la dirección del cliente
        socket_client.sendall(time.ctime().encode()) #Envío de la hora al cliente.
        socket_client.close() #Se cierra el socket del lado del servidor correspondiente a este cliente. 

if __name__ == "__main__":
    #Declaración de las variables necesarias para vincular el servidor a una dirección
    HOST = '127.0.0.1'
    PORT = 4500
    
    #Bloque try-catch para crear el socket del servidor
    try:
        socket_listen = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        print("Socket servidor creaado.")
    except socket.error:
        print("Error al crear el socket del servidor.")
        sys.exit()
    
    #Bloque try-catch para vincular el servidor con una dirección desde la que se pueda comunicar
    try:
        socket_listen.bind((HOST, PORT))
    except socket.error as e:
        print(f"Error socket: {e}")
        sys.exit()
        
    socket_listen.listen(5) #El servidor queda a la espera de algún cliente.
    
    #Bucle para que el cliente acepte a los posibles clientes.
    while True:
        socket_client, addr_client = socket_listen.accept()
        
        #Creación de un hilo que ejecutará la función del servidor con un cliente en paralelo con el resto de clientes
        cliente_hilo = threading.Thread(target=handle_client, args=(socket_client, addr_client))
        cliente_hilo.start()