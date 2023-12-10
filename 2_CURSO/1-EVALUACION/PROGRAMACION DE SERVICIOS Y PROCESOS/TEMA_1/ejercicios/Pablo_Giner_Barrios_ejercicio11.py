import threading
import time
import random

BUF_SIZE = 10
buffer = [None] * BUF_SIZE

semaforo_productor = threading.Semaphore(BUF_SIZE)
semaforo_consumidor = threading.Semaphore(0)

class Productor(threading.Thread):
    def __init__(self, nombre):
        super().__init__()
        self.nombre = nombre
    
    def run(self):
        global BUF_SIZE, buffer
        global semaforo_productor, semaforo_consumidor
        indice_entrada = 0
        for i in range(20):
            time.sleep(random.uniform(0.1, 0.5))
            item = random.choice(["Manzana", "Banana", "Naranja", "Uva"])
            semaforo_productor.acquire
            buffer[indice_entrada] = item 
            indice_entrada = (indice_entrada + 1) % BUF_SIZE
            print(f"El productor {self.nombre} ha añadido el elemento {item}")
            semaforo_consumidor.release()
            
class Consumidor(threading.Thread):
    def __init__(self, nombre):
        super().__init__()
        self.nombre = nombre
    
    def run(self):
        global BUF_SIZE, buffer
        global semaforo_productor, semaforo_consumidor
        indice_salida = 0
        for i in range(20):
            time.sleep(random.uniform(0.1, 0.5))
            semaforo_consumidor.acquire()
            item = buffer[indice_salida]
            indice_salida = (indice_salida + 1) % BUF_SIZE
            print(f"El consumidor {self.nombre} ha sacado el producto {item}")
            semaforo_productor.release()
    

if __name__ == "__main__":
    hilo_productor1 = Productor("Pepe")
    hilo_productor2 = Productor("Josefina")
    hilo_consumidor1 = Consumidor("Mariano")
    hilo_consumidor2 = Consumidor("María")
    
    hilo_productor1.start()
    hilo_productor2.start()
    
    hilo_consumidor1.start()
    hilo_consumidor2.start()
    
    hilo_productor1.join()
    hilo_productor2.join()
    hilo_consumidor1.join()
    hilo_consumidor2.join()
    
    print(buffer)
    print("Todas las operaciones han finalizado")
            