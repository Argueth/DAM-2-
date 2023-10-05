import math

def areaCirculo(radio):
    return math.pi*(radio**2)

def volumenCilindro(radio, altura):
    return areaCirculo(radio) * altura

print(f"{round(volumenCilindro(5, 7), 2)}cm2")