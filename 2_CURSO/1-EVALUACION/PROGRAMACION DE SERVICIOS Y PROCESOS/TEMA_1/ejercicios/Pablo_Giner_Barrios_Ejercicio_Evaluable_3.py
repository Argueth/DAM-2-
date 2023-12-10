import threading
import random
import time

recaudacion_camiones = 0
recaudacion_turismos = 0
lock = threading.Lock()

def peaje_camion():
    global recaudacion_camiones
    with lock:
        recaudacion_camiones += 8
    time.sleep(1)
    print("Ha pasado un camión.")

def peaje_turismo():
    global recaudacion_turismos
    with lock:
        recaudacion_turismos+=4
    time.sleep(1)
    print(f"Ha pasado el turismo con nombre: {threading.current_thread().name}")


if __name__ == "__main__":
    
    hilos = []
    
    for i in range(20):
        tipo = random.choice([0, 1])
        if tipo == 0:
            hilo_camion = threading.Thread(target=peaje_camion)
            hilos.append(hilo_camion)
            hilo_camion.start()
        elif tipo == 1:
            hilo_turismo = threading.Thread(target=peaje_turismo, name=f"turismo{i}")
            hilos.append(hilo_turismo)
            hilo_turismo.start()
            

    for hilo in hilos:
        hilo.join()
        
    print(f"Durante la jornada de hoy se han recaudado {recaudacion_camiones}€ en paso de camiones y {recaudacion_turismos}€ en paso de turismos. Tenemos una recaudación total de: {recaudacion_turismos + recaudacion_camiones}€")
    