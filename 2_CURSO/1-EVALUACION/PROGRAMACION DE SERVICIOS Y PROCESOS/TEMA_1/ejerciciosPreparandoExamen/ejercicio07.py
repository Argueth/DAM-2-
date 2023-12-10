import random
import threading
candidatoA = 0
candidatoB = 0
num_votantes = 0
lock = threading.Lock()

def votacion(identi):
    global candidatoA, candidatoB, num_votantes
    
    voto = random.choice(['A', 'B'])
    if voto == 'A':
        try:
            lock.acquire()
            candidatoA += 1
        except Exception as e:
            print(f"Error al incrementar el contador: {e}")
        finally:
            lock.release()
    else:
        candidatoB += 1
    print(f"Soy el votante {identi} y he votado {voto}")
    num_votantes += 1

if __name__ == "__main__":
    hilos = []
    
    for i in range(10):
        hilo = threading.Thread(target=votacion, args=(i+1,))
        hilos.append(hilo)
        hilo.start()
    
    for hilo in hilos:
        hilo.join()
    
    print(f"Han votado {num_votantes} personas. Candidato A : {candidatoA} -- Candidato B: {candidatoB}")
    if candidatoA != candidatoB:
        print(f"Ganador {'A' if candidatoA > candidatoB else 'B'}")
    else:
        print('EMPATE!!')