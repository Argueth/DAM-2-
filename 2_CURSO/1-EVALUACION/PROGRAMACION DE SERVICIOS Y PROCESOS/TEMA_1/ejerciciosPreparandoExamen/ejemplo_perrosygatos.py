import subprocess
import threading
import time
from ping3 import ping

def ping_google():
    while True:
        #realizar ping a una pagina web( ejemplo: google.com)
        result = ping ("google.com")
        print(f"ping a google.com {result} ms")

        #dormir durante un intervalo de tiempo (5seg)
        time.sleep(5)

def abrir_busqueda(thread_id):
    busqueda = input(f"soy el thread {thread_id}, me puedes indicar que quieres buscar?\n")
    #dormir durante 3 seg
    time.sleep(3)

    try:
        #especifica la busqueda que quieres hacer
        url = f"https://www.google.com/search?q={busqueda}"

        #utiliza subprocess.run para abrir firefox con la url
        subprocess.run(["C:\Program Files\Google\Chrome\Application\chrome.exe",url])

    except Exception as e:
        print(f"Error al abrir Microsoft Edge: {e}")

if __name__ == "__main__":
    #crear el hilo daemon para el ping
    ping_thread = threading.Thread(target=ping_google, daemon=True)

    hilos = []

    #creamos 5 hilos que pediras buscar algo en google
    for i in range(1,6):
        hilo_busca = threading.Thread(target=abrir_busqueda, args=(i,))
        hilos.append(hilo_busca)
        hilo_busca.start()

    #indicar tambien el hilo daemon
    ping_thread.start()

    #el programa principal puede tambien realizar otras tareas
    for _ in range(2):
        print("Programa principal realizando otras tareas....")
        time.sleep(4)

    #Esperar a que los hilos no daemon terminen(opcional)
    for hilo in hilos:
        hilo.join()

    #El programa principal espera a que acaben los hilos no daemon
    #imprimir un mensaje final

    print("Programa orincipal terminado (el hilo de ping daemon continuará en segundo plano)")
