import socket
import sys

if __name__ == "__main__":
    HOST = '127.0.0.1'
    PORT = 5000
    
    try:
        socket_escucha = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        print('Socket servidor creado')
    except socket.error as e:
        print('Fallo en la creación del socket servidor')
        sys.exit()
    
    try:
        socket_escucha.bind((HOST, PORT))
    except socket.error as e:
        print(f"Error socket: {e}")
        sys.exit()
    
    socket_escucha.listen(5) #El servidor puede escuchar hasta 5 clientes. 
    
    while True:
        socket_atiende, addr_cliente = socket_escucha.accept()
        
        fin_mensaje = b''
        
        with socket_atiende:
            print(f"Conexión exitosa con el cliente. {addr_cliente}")
            cerrar = False
            while not cerrar:
                data = socket_atiende.recv(1024)
                if data == fin_mensaje:
                    cerrar = True
                else:
                    print(f"EL cliente {addr_cliente} nos ha escrito: {data.decode()}")
                    socket_atiende.sendall(b"mensaje recibido")
            print(f"Fin de conversación con : {addr_cliente}")
            socket_atiende.close()
        