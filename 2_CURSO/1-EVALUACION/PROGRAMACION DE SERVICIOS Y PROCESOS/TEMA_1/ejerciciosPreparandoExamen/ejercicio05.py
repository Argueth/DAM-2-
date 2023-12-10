import threading

def dividir(identidficador, num):
    print(f"Soy el thread con nombre {threading.current_thread().name}, mi identficador es {identidficador} y el resultado es: {num/5}")

def multiplicar(identificador, num):
    print(f"Soy el thread con nombre {threading.current_thread().name}, mi identficador es {identificador} y el resultado es: {num*5}")

if __name__ == "__main__":
    hilos = []
    
    for i in range(5):
        hilo = threading.Thread(target=dividir, args=(i+1, i), name=f"hiloDiv{i+1}")
        hilos.append(hilo)
        hilo.start()
    for i in range(5):
        hilo = threading.Thread(target=multiplicar, args=(i+1, i), name=f"hiloMult{i+1}")
        hilos.append(hilo)
        hilo.start()
        
    for hilo in hilos:
        hilo.join()
        
    print("El juego ha terminado")