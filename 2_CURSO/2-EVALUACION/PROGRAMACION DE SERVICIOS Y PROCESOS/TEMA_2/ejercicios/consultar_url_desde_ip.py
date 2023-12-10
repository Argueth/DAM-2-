import socket

ip = "213.201.83.138"
try:
    dominio = socket.gethostbyaddr(ip)[0]
    print(f"La IP {ip} tiene una entrada DNS: {dominio}")
except socket.error as e:
    print(f"{ip}: {e}")