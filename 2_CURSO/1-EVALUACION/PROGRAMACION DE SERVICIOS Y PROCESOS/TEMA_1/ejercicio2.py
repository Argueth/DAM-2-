from pathlib import Path

def calcularVocales(frase):
    """Dada una frase, la función retorna la cantidad de vocales que contiene"""
    vocales = ('a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú')
    resultado = 0
    for palabra in frase.lower():
        for letra in palabra:
            if letra in vocales:
                resultado+=1
    return resultado

if __name__ == "__main__":
    resultado = 0
    archivoPath = Path(__file__).parent

    try:
        f1 = open(archivoPath/"solucion.txt", "w")
    except OSError as e:
        print("Fichero1:", e)
    
    try:
        f2 = open(archivoPath/"frases.txt", "r")
        numLinea=1
        for line in f2.readlines():
            resultado = calcularVocales(line.lower())
            f1.write(f"Frase {numLinea}: {resultado} vocales\n")
            numLinea+=1

    except OSError as e:
        print("Fichero2:", e)
