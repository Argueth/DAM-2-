import socket
import struct
import time

def get_ntp_time(socket, ntp_server, ntp_port):
    ntp_request = b'\x1b' + 47 * b'\0'
    
    try:
        socket.sendto(ntp_request, (ntp_server, ntp_port))
        
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
    ntp_server = 'time.google.com'
    ntp_port = 123
    
    try:
        client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        
    except socket.error as e:
        print(f"Error al crear el socket UDP: {e}")
    
    ntp_hora = get_ntp_time(client_socket, ntp_server, ntp_port)
    
    if ntp_hora:
        print(f"Hora del servidor NTP: {ntp_hora}")
    else:
        print("No se pudo obtener la hora del servidor NTP.")