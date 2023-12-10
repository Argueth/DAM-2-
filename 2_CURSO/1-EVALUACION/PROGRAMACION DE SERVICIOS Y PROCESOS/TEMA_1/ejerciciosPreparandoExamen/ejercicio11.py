import threading
import time
import random

BUF_SIZE = 10
buffer = [None]*BUF_SIZE
semaforo_productor = threading.Semaphore(BUF_SIZE)
semaforo_consumidor = threading.Semaphore(0)
indice_entrada = 0
num_frutas = 0
num_verduras = 0

class Productor_Verdura(threading.Thread):
    def run(self):
        global BUF_SIZE, buffer, indice_entrada, num_verduras
        global semaforo_productor, semaforo_consumidor
        for _ in range(10):
            time.sleep(random.uniform(0.1, 0.5))
            verduras = ['Acelgas', 'Coliflor', 'Boniato', 'Lechuga']
            item = random.choice(verduras)
            semaforo_productor.acquire()
            buffer[indice_entrada] = item
            num_verduras += 1
            indice_entrada = (indice_entrada+1)%BUF_SIZE
            print(f"El productor de verdura ha añadido el elemento {item}")
            semaforo_consumidor.release()

class Productor_Fruta(threading.Thread):
    def run(self):
        global BUF_SIZE, buffer, indice_entrada, num_frutas
        global semaforo_consumidor, semaforo_productor
        for _ in range(10):
            frutas = ['Manzana', 'Pera', 'Melón', 'Sandía']
            item = random.choice(frutas)
            semaforo_productor.acquire()
            buffer[indice_entrada] = item
            num_frutas += 1
            indice_entrada = (indice_entrada + 1) % BUF_SIZE
            print(f"El producto de fruta ha añadido el elemento {item}")
            semaforo_consumidor.release()

class Consumidor(threading.Thread):
    def run(self):
        global BUF_SIZE, buffer
        global semaforo_productor, semaforo_consumidor
        indice_salida = 0
        for _ in range(20):
            time.sleep(random.uniform(0.1, 0.5))
            semaforo_consumidor.acquire()
            producto = buffer[indice_salida]
            indice_salida = (indice_salida + 1) % BUF_SIZE
            print(f"El consumidor ha sacado el producto {producto}")
            semaforo_productor.release()

if __name__ == "__main__":
    hilo_productor_verduras = Productor_Verdura()
    hilo_productor_frutas = Productor_Fruta()
    
    hilo_consumidor = Consumidor()
    
    hilo_productor_verduras.start()
    hilo_productor_frutas.start()
    hilo_consumidor.start()
    
    hilo_productor_verduras.join()
    hilo_productor_frutas.join()
    hilo_consumidor.join()
    
    print("Todas las operaciones han terminado.")
    print(f"El consumidor compró {num_verduras} verduras y {num_frutas} frutas")
        