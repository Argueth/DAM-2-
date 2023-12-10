import random
import threading
candidatoA = 0
candidatoB = 0
num_votantes = 0
lock = threading.Lock()

class votante (threading.Thread):
    def __init__(self, lock, identi):
        super().__init__()
        self.lock = lock
        self.identi = identi
    
    def run(self):
        global candidatoA, candidatoB, num_votantes
        voto = random.choice(['A', 'B'])
        if voto == 'A':
            with self.lock:
                candidatoA += 1
        else:
            with self.lock:
                candidatoB += 1
        print(f"Soy el votante {self.identi} y he votado {voto}")
        num_votantes += 1

if __name__ == "__main__":
    hilos = []
    
    for i in range(10):
        hilo = votante(lock, i+1)
        hilos.append(hilo)
        hilo.start()
    
    for hilo in hilos:
        hilo.join()
    
    print(f"Han votado {num_votantes} personas. Candidato A : {candidatoA} -- Candidato B: {candidatoB}")
    if candidatoA != candidatoB:
        print(f"Ganador {'A' if candidatoA > candidatoB else 'B'}")
    else:
        print('EMPATE!!')