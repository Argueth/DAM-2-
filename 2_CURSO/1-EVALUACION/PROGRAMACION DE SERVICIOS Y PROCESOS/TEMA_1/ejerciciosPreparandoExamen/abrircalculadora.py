import subprocess
import threading
import time

def hilo_daemon():
    while(True):
        subprocess.run(['ping','www.google.es','-n','2'])
        time.sleep(2)

def abrir_programas():
    try:
        subprocess.run(['Notepad.exe'])
        subprocess.Popen(['C:\\Windows\\System32\\calc.exe'])
    except FileNotFoundError as e:
        print(f"Archivo no encontrado en la ubicación predeterminada: {e}")
    except Exception as e:
        print(f"Se produjo un error al abrir el programa: {e}")

if __name__ == "__main__":
    
    hilo_D = threading.Thread(target=hilo_daemon, daemon=True)
    hilo_D.start()
    time.sleep(2)
    
    hilo = threading.Thread(target=abrir_programas)
    hilo.start()
    
    time.sleep(15)
    
    print("Adiós gilipollas.")
    
    
    