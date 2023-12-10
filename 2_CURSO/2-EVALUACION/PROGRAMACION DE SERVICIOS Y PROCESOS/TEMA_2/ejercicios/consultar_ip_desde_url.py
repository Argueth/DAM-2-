import socket

try:
    host = 'www.amazon.com'
    print(f"IP de {host}: {socket.gethostbyname(host)}")
except socket.error as e:
    print(f"{host}: {e}")