import random
import threading

candidatoA = 0
candidatoB = 0
num_votantes = 0

def votacion(identi):
    global candidatoA, candidatoB, num_votantes
    
    voto = random.choice(['A', 'B'])
    if voto == 'A':
        candidatoA += 1
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