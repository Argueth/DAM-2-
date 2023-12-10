import threading
import time
import random

def calcularVocales(identificador):
    """Dada una frase, la función retorna la cantidad de vocales que contiene"""
    frase = input("Introduce una frase: ")
    vocales = ('a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú')
    resultado = 0
    for palabra in frase.lower():
        for letra in palabra:
            if letra.lower() in vocales:
                resultado+=1
    print(f"La frase \"{frase}\" tiene {resultado} vocales. Hilo {identificador}")
    tiempo_espera = random.randint(1, 5)
    time.sleep(tiempo_espera)
    print(f"Soy {threading.current_thread().name}")

if __name__ == "__main__":
    print("Este programa calcula la cantidad de vocales que contiene una frase.")
    hilos = []
    for i in range(5):
        hilo = threading.Thread(target=calcularVocales, args=(i,), name=f"hilo {i} personalizado")
        hilos.append(hilo)
        hilo.start()
        
        
        