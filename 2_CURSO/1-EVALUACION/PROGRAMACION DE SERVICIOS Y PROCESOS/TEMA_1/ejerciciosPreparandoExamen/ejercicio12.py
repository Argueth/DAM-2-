import random
import time
import threading

numero_trabajadores = 4
barrera_fabricacion = threading.Barrier(numero_trabajadores + 1)
barrera_montaje = threading.Barrier(numero_trabajadores)

def fabricacion():
    print(f"El trabajador {threading.current_thread().name} ha empezado a trabajar en la pieza.")
    time.sleep(random.uniform(0.1, 0.5))
    barrera_fabricacion.wait()

def montaje():
    print(f"El trabajador {threading.current_thread().name} ha empezado a montar las piezas")
    time.sleep(random.uniform(0.1, 0.5))
    barrera_montaje.wait()

if __name__ == "__main__":
    hilos_fabricacion = []
    hilos_montaje = []
    
    for i in range(numero_trabajadores):
        hilo = threading.Thread(target=fabricacion, name = f"Trabajador{i+1}")
        hilos_fabricacion.append(hilo)
        hilo.start()
    
    barrera_fabricacion.wait()
    print("La fabricación de las piezas ha terminado. Empieza el montaje.")
    
    for i in range(numero_trabajadores):
        hilo = threading.Thread(target=montaje, name=f"Trabajador{i+1}")
        hilos_montaje.append(hilo)
        hilo.start()
    
    for hilo in hilos_montaje:
        hilo.join()
        
    print("El montaje de las piezas ha terminado. El producto final está preparado para su venta.")

    