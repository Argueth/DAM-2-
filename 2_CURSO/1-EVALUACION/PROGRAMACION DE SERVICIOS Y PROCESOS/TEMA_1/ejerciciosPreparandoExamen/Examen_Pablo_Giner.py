import threading
import random
import time

#declaración de las variables globales
almacen = 20
productos_sacados_almacen = 0
productos_introducidos_almacen = 0
relojAlmacen = 240
camiones = 0

#semaforo para el control de los muelles de los camiones.
semaforo_muelles = threading.Semaphore(10)

#Clase para simular los operarior de la empresa    
class Operario(threading.Thread):
    def __init__(self, nombre, lock): #Al constructor le mando el nombre y el lock
        super().__init__(name=nombre)
        self.jornada = 240
        self.cajas = 0 #El operario empieza habiendo movido 0 cajas.
        self.lock = lock #El lock es el global
    
    def run(self):
        #Declaración de las variables globales que serán modificadas a lo largo del trabajo del operario
        global almacen, productos_sacados_almacen
        
        #El bucle que hace que el operario trabaje a lo largo de su jornada y deje de hacerlo cuando termina.
        while self.jornada > 0:
            
            #El operario no puede coger nada del almacén si solo quedan en este 3 o menos productos.
            if almacen > 3: 
                tiempo = random.uniform(0.3,0.7) #Random para simular el tiempo que tarda el operario en mover los productos.
                self.jornada -= tiempo*10 #Se reduce el tiempo de jornada que le queda al operario con cada movimiento de productos.
                with self.lock: #Prottejo las variables globales que voy a modificar para evitar condiciones de carrera.
                    almacen -= 3 #Se reduce el contenido del almacén en 3, que son las cajas que mueve el operario a la tienda.
                    productos_sacados_almacen += 3 #Incrementa en 3 la cantidad de cajas que se han movido en total.
                time.sleep(tiempo) 
                
                #Este print lo he puesto para comprobar yo mismo que todo funciona, pero he decidido dejártelo porque creo que puede serte útil para corregir. 
                print(f"{threading.current_thread().name} ha movido 3 productos. En el almacén quedan {almacen} productos.")
                self.cajas += 3 #Incrementa en 3 el número de cajas que mueve este operario en concreto.
            else:
                #Si en el almacén solo quedan 3 productos o menos, el operario  descansa un poco
                #y gasta 5 de sus jornada laboral. Además, se imprimer que está esperando.
                time.sleep(0.2)
                self.jornada -=5
                print(f"El operario con PID: {threading.current_thread().name} está esperando.")
        print(f"{threading.current_thread().name} ha terminado su jornada. Ha movido {self.cajas} cajas.")

#Clase para simular el comportamiento de los camiones. 
class Camion(threading.Thread):
    def __init__(self, nombre, lock): #En el constructor recibe el nombre y el lock.
        super().__init__(name=nombre)
        self.lock = lock
       
    def run(self):
        #Declaración de las variables globales que serán modificadas durante el comportamiento del camión.
        global productos_introducidos_almacen, semaforo_muelles, relojAlmacen, almacen
        descarga = False #Booleano que he creado para controlar cuándo el camión ha podido ejecutar su descarga.
        semaforo_muelles.acquire() #El camión llega, así que ocupa un muelle (hace uso de uno de los huecos del semáforo)
        #Este bucle sirve para que el camión ocupe el muelle el tiempo que sea necesario hasta que pueda completar la descarga.
        while descarga == False:
            #El camión solo puede descargar si en el almacén hay 80 o menos objetos.
            if almacen <= 80:
                cantidad = random.randint(1,10) #Aquí se usa un random para decidir cuántos productos va a descargar el camión.
                with self.lock: #Bloqueo para proteger las variables globales que van a ser modificadas.
                    productos_introducidos_almacen += cantidad
                    almacen += cantidad
                print(f"{threading.current_thread().name} ha metido {cantidad} productos en el almacén.")
                semaforo_muelles.release() #Libero el muelle una vez que el camión ha descargado
                #Finalmente completo la descarga y el booleano se pasa a True, lo que hace que el bucle no se repita más.
                descarga = True 
            else:
                #Si el almacén está lleno, el camión no puede descargar, lo que implica que no libera el muelle y se 
                #queda esperando.
                time.sleep(0.2)
                #Utilizo el lock para proteger la variable global que voy a modificar. El tiempo de almacén disminuye.
                with self.lock:  
                    relojAlmacen -= 10
 
if __name__ == "__main__":
    
    #Creo el lock
    lock = threading.Lock()
    
    #Lista de operarios para facilitar el acceso al dato de cuántos productos ha sacado cada operario al final de la jornada.
    operarios = []
    #Lista de todos los hilos (operarios y camiones) para facilitar el uso de join al final del programa principal.
    hilos = []
    
    #Creación de los 6 operarios
    for i in range(6):
        hilo = Operario(f'Operario{i+1}', lock)
        operarios.append(hilo)
        hilos.append(hilo)
        hilo.start()
    
    #Bucle que crea camiones mientras el reloj del almacén no llegue a 0.
    while relojAlmacen > 0:
        #Solo se crean camiones mientras haya menosde 30 camiones recibidos en un solo día.
        if camiones < 30:
           hilo = Camion(f"Camion{camiones+1}", lock)
           hilos.append(hilo)
           hilo.start()
           camiones += 1
        #Mientras no se acabe el tiempo del almacén, este sigue recudiéndose, haya camión nuevo o no.
        tiempo_espera = random.uniform(0.1,0.3) #Random para ver cuánto tiempo espera
        time.sleep(tiempo_espera) #Tiempo de espera
        with lock:
            relojAlmacen -= tiempo_espera*20 #Se reduce el tiempo del almacén
    
    for hilo in hilos:
        hilo.join() #Se aplica join a todos los hilos para termina la jornada laboral cuando todos los empleados han finalizado.
    
    print("**********************FIN DE LA JORNADA****************************")   
    print(f"En el almacén hay un total de {almacen} productos.")
    for hilo in operarios: #Recorro la lista de operarios para mostrar cuántos productos ha movido cada uno a lo largo de la jornada. 
        print(f"{hilo.name} ha sacado {hilo.cajas} productos.")
    print(f"Los operarios han sacado {productos_sacados_almacen} productos.")
    print(f"Los camiones han metido {productos_introducidos_almacen} productos.")
        