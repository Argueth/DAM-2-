"""Hay dos candiddatos: candidatoA y candidatoB. En el colegio electoral caben, como máximo, 10 personas. Hay dos tandas
de votación: la de mañana y la de tarde. No se puede comenzar la de tarde hasta que haya terminado la de la mañana.
No se puede el resultado hasta que todos hayan votado."""

import threading
import random
import time

candidatoA = 0
candidatoB = 0
num_votantes = 20
barrera_manana = threading.Barrier(num_votantes + 1)
barrera_tarde = threading.Barrier(num_votantes)
lock = threading.Lock()
semaforo_colegio = threading.Semaphore(5)

class votante_mañana(threading.Thread):
    def __init__(self, nombre, lock):
        super().__init__(name=nombre)
        self.lock = lock
        
    def run(self):
        global candidatoA, candidatoB, barrera_manana
        if semaforo_colegio._value == 0:
            print(f"{threading.current_thread().name} está esperando para votar.")
        with semaforo_colegio:
            time.sleep(random.randint(1,2))
            voto = random.choice(['A', 'B'])
            if voto == 'A':
                with self.lock:
                    candidatoA += 1
            else:
                with self.lock:
                    candidatoB += 1
            print(f"Soy el votante {threading.current_thread().name} y he votado {voto}")
        barrera_manana.wait()

class votante_tarde(threading.Thread):
    def __init__(self, nombre, lock):
        super().__init__(name=nombre)
        self.lock = lock
    
    def run(self):
        global candidatoA, candidatoB, barrera_tarde
        if semaforo_colegio._value == 0:
            print(f"{threading.current_thread().name} está esperando para votar.")
        with semaforo_colegio:
            time.sleep(random.randint(1,2))
            voto = random.choice(['A', 'B'])
            if voto == 'A':
                with self.lock:
                    candidatoA += 1
            else:
                with self.lock:
                    candidatoB += 1
            print(f"Soy el votante {threading.current_thread().name} y he votado {voto}")
        barrera_tarde.wait()

def abrir_colegio():
    while True:
        print("El colegio electoral está abierto.")
        time.sleep(2)

if __name__ == "__main__":
    
    hilos = []
    
    hilo_daemon = threading.Thread(target=abrir_colegio, daemon=True)
    hilo_daemon.start()
    
    for i in range(num_votantes):
        hilo = votante_mañana(f'Votante_Mañanero{i+1}', lock)
        hilos.append(hilo)
        hilo.start()
    
    barrera_manana.wait()
    print("Han terminado las votaciones de la mañana.")
    print("Esperemos 5 segundos hasta la votación de la tarde.")
    time.sleep(5)
    
    for i in range(num_votantes):
        hilo = votante_tarde(f'Votante_Tardero{i+1}', lock)
        hilos.append(hilo)
        hilo.start()
        
    for hilo in hilos:
        hilo.join()
    
    print("Ha terminado el día de votaciones.")
    print(f"Han votado {num_votantes * 2} personas. Candidato A : {candidatoA} -- Candidato B: {candidatoB}")
    if candidatoA != candidatoB:
        print(f"Ganador {'A' if candidatoA > candidatoB else 'B'}")
    else:
        print('EMPATE!!')