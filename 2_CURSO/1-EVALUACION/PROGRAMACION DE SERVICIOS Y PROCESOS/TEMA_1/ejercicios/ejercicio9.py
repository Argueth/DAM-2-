import random
import threading

CandidatoA = 0
CandidatoB = 0
numVotantes = 0
lock = threading.Lock()

class votacionHilos(threading.Thread):
    def __init__(self, lock, votante):
        super().__init__()
        self.lock = lock
        self.votante = votante
        
    def run(self):
        global CandidatoA, CandidatoB, numVotantes
        voto = random.choice(['A', 'B'])
        with self.lock:
            if voto == 'A':
                CandidatoA += 1
            else:
                CandidatoB += 1
            print(f"Soy el votante {self.votante} y he votado {voto}. {threading.current_thread().name}")
            numVotantes+=1
    
if __name__ == "__main__":
    
    hilos = []
    
    for i in range(1,11):
        hilo = votacionHilos(lock, i)
        hilos.append(hilo)
        hilo.name = f"Hilo {str(i)}"
        hilo.start()
    
    for hilo in hilos:
        hilo.join()
    
    print(f"Han votado {numVotantes} personas.\nEl total de votos para A es: {CandidatoA}\nEl total de votos para B es: {CandidatoB}")
    