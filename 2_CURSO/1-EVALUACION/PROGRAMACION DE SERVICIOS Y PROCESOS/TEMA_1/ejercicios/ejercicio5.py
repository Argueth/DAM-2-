import threading

def dividir(num):
    resultado = num / 5
    nombre = threading.current_thread().name
    identificador = threading.get_ident()
    print(f"Soy el thread con nombre {nombre}. Mi identificador es {identificador} y el resultado del número {num} divididor por 5 es {resultado}")

def multiplicar(num):
    resultado = num * 5
    nombre = threading.current_thread().name
    identificador = threading.get_ident()
    print(f"Soy el thread {nombre}. Mi identificadores {identificador}. El resultado de {num} por 5 es {resultado}.")
    
if __name__ == "__main__":
    hilos = []
    
    for i in range(1, 11):
        if i < 6:
            hilo = threading.Thread(target=dividir, args=(i,))
            hilos.append(hilo)
            hilo.start()
        elif i < 11:
            hilo = threading.Thread(target=multiplicar, args=(i,), name=f"HiloMulti{i}")
            hilos.append(hilo)
            hilo.start()