import socket

def pedir_pagina_web(socket_cliente, web_path):
    
    peticion = f'GET {web_path} HTTP/1.1\r\nHost: example.com\r\nConnection: close\r\n\r\n'
    
    try:
        socket_cliente.sendall(peticion.encode())
        
        mensaje = b''
        while True:
            datos = socket_cliente.recv(1024)
            if not datos:
                break
            mensaje += datos
        print(mensaje.decode())
    except socket.error as exc:
        print(f"Exceptión de socket: {exc}")

if __name__ == "__main__":
    web_host = "example.com"
    web_port = 80
    web_path = "/"
    
    try:
        socket_cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM) #Creo el socket
    except socket.error as e:
        print(f"Error al crear el socket: {e}")
        raise
    
    try:
        socket_cliente.connect((web_host,web_port)) #El socket se conecta al servidor
    except socket.error as e:
        print(f"Error al conectar el socket: {e}")
        raise
    print('Conectado con éxito.')
    
    pedir_pagina_web(socket_cliente, web_path) #Mando el socket y la URL y el Port de la web para hacer la petición.