import threading
import time
import random

semaforo_biblioteca = threading.Semaphore(10)

def entrar_sala():
    print(f"{threading.current_thread().name} pide entrar en la sala.")
    if semaforo_biblioteca._value == 0:
        print(f"No hay espacio en la sala.{threading.current_thread().name} se queda esperando para entrar.")
    semaforo_biblioteca.acquire()
    print(f"{threading.current_thread().name} entra en la sala.")
    tiempo = random.randint(1,5)
    time.sleep(tiempo)
    semaforo_biblioteca.release()
    print(f"{threading.current_thread().name} ha estado en la sala {tiempo} minutos y ya se va.")
    
if __name__ == "__main__":
    hilos = []
    
    for i in range(20):
        hilo_estudiante = threading.Thread(target=entrar_sala, name=f"estudiante {i+1}")
        hilos.append(hilo_estudiante)
        hilo_estudiante.start()
    
    for hilo in hilos:
        hilo.join()
    
    print("La sala de estudios cierra por hoy. Hasta mañana.")