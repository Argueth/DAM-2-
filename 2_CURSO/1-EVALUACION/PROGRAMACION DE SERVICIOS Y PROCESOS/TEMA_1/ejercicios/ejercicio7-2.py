import random
import threading

import random
import threading

CandidatoA = 0
CandidatoB = 0
numVotantes = 0
lock = threading.Lock()

def votacion(votante):
    global CandidatoA, CandidatoB, numVotantes
    voto = random.choice(['A', 'B'])
    try:
        lock.acquire()
        if voto == 'A':
            CandidatoA += 1
        else:
            CandidatoB += 1
        print(f"Soy el votante {votante} y he votado {voto}")
        numVotantes += 1
    except Exception as e:
        print(f"Error al modificar alguna variable global: {e}")
    finally:
        lock.release()
    
if __name__ == "__main__":
    threads = []
    
    for i in range(1, 11):
        thread = threading.Thread(target=votacion, args=(i,))
        threads.append(thread)
        thread.start()
    
    for thread in threads:
        thread.join()

    print(f"Han votado {numVotantes} personas.\nEl total de votos para A es: {CandidatoA}\nEl total de votos para B es: {CandidatoB}")