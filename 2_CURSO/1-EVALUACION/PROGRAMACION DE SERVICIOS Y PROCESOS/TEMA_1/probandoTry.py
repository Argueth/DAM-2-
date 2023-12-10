from pathlib import Path

def sumar(n1, n2):
    resultado = 0
    for i in range(n1, n2+1):
        resultado += i
    return resultado

if __name__ == "__main__":
    resultado = 0
    fichero_path = Path(__file__).parent
    
    try:
        f1 = open(fichero_path/"solucion.txt", "w")
    except OSError as e:
        print(f"Fichero1: {e}")
    else:
        try:
            f2 = open(fichero_path/"numeros.txt", "r")
            for line in f2.readlines():
                n1, n2 = [int(x) for x in line.split(",")]
                resultado = sumar(n1, n2)
                print(f"La suma de los números entre {n1} y {n2} es: {resultado}", file=f1)
        except OSError as e:
            print(f"FIchero2: {e}")