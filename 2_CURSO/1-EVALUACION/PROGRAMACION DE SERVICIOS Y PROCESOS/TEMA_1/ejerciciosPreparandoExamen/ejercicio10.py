import threading
import time

semaforo_fruteria = threading.Semaphore(4)

class Comprador(threading.Thread):
    def __init__(self, identi):
        super().__init__()
        self.identi = identi
        
    def run(self):
        if semaforo_fruteria._value == 0:
            print(f"Comprador {self.identi} esperando.")
        
        semaforo_fruteria.acquire()
        time.sleep(2)
        print(f"El comprador {self.identi} ha terminado de comprar y sale de la frutería.")
        semaforo_fruteria.release()

if __name__ == "__main__":
    hilos = []
    
    for i in range(10):
        hilo = Comprador(i+1)
        hilos.append(hilo)
        hilo.start()
        
    for hilo in hilos:
        hilo.join()
    
    print("Salieron todos.")
        