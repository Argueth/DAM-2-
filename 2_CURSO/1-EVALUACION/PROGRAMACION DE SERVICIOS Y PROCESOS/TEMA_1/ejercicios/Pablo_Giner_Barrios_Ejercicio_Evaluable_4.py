import threading
import random
import time

semaforo_biblioteca = threading.Semaphore(10)

def entra_biblioteca(identificador):
    if semaforo_biblioteca._value == 0:
        print(f"Estudiante {identificador} está esperando para entrar.")
    
    semaforo_biblioteca.acquire()
    print(f"El estudiante {identificador} usa un cubículo para estudiar.")
    tiempo_estudio = random.choice([2, 3, 4, 5])
    time.sleep(tiempo_estudio)
    semaforo_biblioteca.release()
    print(f"El estudiante {identificador} ha estado en el cubículo {tiempo_estudio} de estudio y ya se va.")


if __name__ == "__main__":
    
    hilos = []
    
    for i in range(20):
        hilo = threading.Thread(target=entra_biblioteca, args=(i + 1,))
        hilos.append(hilo)
        hilo.start()
    
    for hilo in hilos:
        hilo.join()
    
    print("La sala de estudios cierra por hoy. Hasta mañana.")
        