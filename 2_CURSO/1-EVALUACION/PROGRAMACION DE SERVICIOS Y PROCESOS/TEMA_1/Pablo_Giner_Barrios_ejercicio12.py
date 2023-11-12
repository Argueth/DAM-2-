import threading
import time
import random

numTrabajadores = 4
barrera_fabricacion = threading.Barrier(numTrabajadores + 1)
barrera_montaje = threading.Barrier(numTrabajadores)

def fabricacionPiezas(trabajador):
    print(f"El trabajador {trabajador} se ha puesto a hacer una pieza.")
    time.sleep(random.uniform(2, 5))
    barrera_fabricacion.wait()
    
def montajePiezas(trabajador):
    print(f"El trabajador {trabajador} ha empezado a montar las piezas.")
    time.sleep(random.uniform(2, 5))
    barrera_montaje.wait()
    print(f"El trabajador {trabajador} ha terminado de montar sus piezas.")



if __name__ == "__main__":
    
    hilosFabricacion = []
    hilosMontaje = []
    
    for i in range(numTrabajadores):
        hilo = threading.Thread(target=fabricacionPiezas, args=(i+1,))
        hilosFabricacion.append(hilo)
        hilo.start()
    
    barrera_fabricacion.wait()
    
    print("Los trabajadores han terminado de fabricar las piezas.")
    
    for i in range(numTrabajadores):
        hilo = threading.Thread(target=montajePiezas, args=(i+1,))
        hilosMontaje.append(hilo)
        hilo.start()
        
    for hilo in hilosMontaje:
        hilo.join()
        
    print("La fabricación y el montaje han terminado.")