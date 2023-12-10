import socket
import struct
import time

def get_ntp_time(socket, dominio, ntp_port):
    ntp_request = b'\x1b' + 47 * b'\0'
    
    try:
        socket.sendto(ntp_request, (dominio, ntp_port))
        
        ntp_response, server_address = socket.recvfrom(1024)
    except socket.error as e:
        print(f"Error al conectar al servidor NTP: {e}")
        return None
    finally:
        socket.close()
    
    unpacked_response = struct.unpack('!12I', ntp_response)
    ntp_seconds = unpacked_response[10] - 2208988800
    
    tiempo_servidor = time.strftime('%Y-%m-%d %H:%M:%S', time.gmtime(ntp_seconds))
    
    return tiempo_servidor

if __name__ == "__main__":
    ntp_server = '216.239.35.4' #Ahora ntp_server es la ip de time.google.es
    ntp_port = 123 #El puerto, lógicamente, se mantiene.
    
    try:
        client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    except socket.error as e:
        print(f"Error al crear el socket UDP: {e}")
        raise #Añado la palabra clave raise para que, si el socket no ha podido crearse, se cierre el programa.
    
    #Intento conseguir la url a partir de la ip.
    try:
        dominio = socket.gethostbyaddr(ntp_server)[0]
    except socket.error as e:
        print(f"{ntp_server}: {e}")
        raise #Añado la palabra clave raise para que se cierre el programa en caso de error y no siga ejecutándose el código que sigue.
    
    #Mando como argumento el dominio en lugar de la variable ntp_server que es la ip.
    ntp_hora = get_ntp_time(client_socket, dominio, ntp_port)
    
    if ntp_hora:
        print(f"Hora del servidor NTP: {ntp_hora}")
    else:
        print("No se pudo obtener la hora del servidor NTP.")