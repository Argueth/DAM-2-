class Contador:
    def contar(self, frase):
        cont = 0
        for letra in frase:
            if letra in ['a','á','A', 'e','é','E','i','í','I','o','ó','O','u','ú','U']:
                cont += 1
        return cont

if __name__ == "__main__":
    c = Contador()
    frase = input("Introduce una frase: ")
    print(f"La frase tiene {c.contar(frase)} vocales")