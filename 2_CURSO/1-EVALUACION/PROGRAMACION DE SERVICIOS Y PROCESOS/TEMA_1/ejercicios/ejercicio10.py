import threading
import time

semaforo_fruteria = threading.Semaphore(4)

def entradaFruteria(numero_persona):
    if(semaforo_fruteria._value == 0):
        print(f"Persona {numero_persona} esperando")
        print(f" Persona {numero_persona} - quedan {semaforo_fruteria._value} sitios")
        
    semaforo_fruteria.acquire()
    print(f"Persona {numero_persona} entra en la frutería.")
    print(f"Persona {numero_persona} quedan {semaforo_fruteria._value} sitios")
    time.sleep(10)
    semaforo_fruteria.release()
    print(f"Persona {numero_persona} sale de la frutería.")
    print(f"Persona {numero_persona} quedan {semaforo_fruteria._value} sitios")
        


if __name__ == "__main__":
    
    hilos = []
    
    for i in range(1, 11):
        hilo = threading.Thread(target=entradaFruteria, args=(i,))
        hilos.append(hilo)
        hilo.start()
        time.sleep(2)
    
    for hilo in hilos:
        hilo.join()
        
    print("Todas las personas han comprado en la frutería y se han ido.")
        