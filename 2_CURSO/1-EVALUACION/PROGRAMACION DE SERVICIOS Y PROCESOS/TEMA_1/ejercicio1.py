class Vocalizador:
    def calcularVocales(self, frase):
        """Dada una frase, la función retorna la cantidad de vocales que contiene"""
        vocales = ('a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú')
        resultado = 0
        for palabra in frase.lower():
            for letra in palabra:
                if letra in vocales:
                    resultado+=1
        return resultado

if __name__ == "__main__":
    s=Vocalizador()
    print("Este programa calcula la cantidad de vocales que contiene una frase.")
    frase = input("Introduce una frase: ")
    resultado = s.calcularVocales(frase)
    print(f"La frase introducida contiene {resultado} vocales")

