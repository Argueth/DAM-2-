import socket
import sys

HOST = '127.0.0.1'
PORT = 5000

def programa_cliente():
    try:
        socket_cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        print("Socket cliente creado.")
    except socket.error:
        print("Error al crear el socket cliente.")
        sys.exit()
        
    socket_cliente.connect((HOST, PORT))
    
    mensaje = 'Conectado con el servidor'
    
    with socket_cliente:
        while mensaje != 'bye':
            socket_cliente.sendall(mensaje.encode())
            
            data = socket_cliente.recv(1024)
            print(f'Recibido del servidor: {data.decode()}')
            mensaje = input('Escribe tu mensaje (Para finalizar escribe: bye) --> ')

if __name__ == "__main__":
    programa_cliente()