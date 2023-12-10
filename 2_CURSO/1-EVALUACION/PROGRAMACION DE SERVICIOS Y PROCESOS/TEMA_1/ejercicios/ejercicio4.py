import threading

def tarea_animal(tupla):

        animal, patas, vuela = tupla
        vuelo = "vuela" if vuela else "no vuela"
        informacion = f"{animal} es un animal con {patas} patas y {vuelo}."
        print(informacion)


if __name__ == "__main__":
    #declaracion de las listas
    animales = ["Perro","Pájaro","Araña"]
    patas = [4,2,8]
    vuela = [False,True,False]

    lista = list(zip(animales, patas, vuela))
    hilos = []
    for i in lista:
        # Crear e iniciar hilos para diferentes animales con patas y si vuelan
        hilo = threading.Thread(target=tarea_animal, args=(i,))
        #guardar los hilos en la lista hilos
        hilos.append(hilo)
        # Iniciar los hilos
        hilo.start()