import random

played_games = 0
games_summary = []

def start_menu():
    salir = False
    while not salir:
        print("""
    MENÚ DE JUEGO
======================================
    1 - Jugar una partida
    2 - Ver resumen de partidas
    3 - Salir
======================================
            """)
        option = check_option(1, 3)
        if option == 1:
            play_game()
        elif option == 2:
            show_summary()
        elif option == 3:
            print("\nAdiós!!!!\n")
            salir = True

def check_option(min, max):
    while True:
        try:
            option = int(input("Introduce el número de la opción deseada: -->"))
            if min <= option <= max:
                return option
            else:
                print("\nOpción no válida.\n")
        except ValueError:
            print(f"\nPor favor, introduce un entero entre {min} y {max}.\n")

def play_game():
    player_life = 20
    computer_life = 20
    
    player_nick = input("Introduce el nombre de tu personaje: -->")
    long = 48 - len(player_nick)
    while player_life > 0 and computer_life > 0:
        print(f"\n{player_nick}{'Computer':>{long}}\n[{'='*player_life + ' '*(20-player_life)}] VS [{'='*computer_life + ' '*(20-computer_life)}]\n")
        if computer_life > 3:
            hit = hit_menu_1()
        else:
            hit = hit_menu_2()
        damage = calculate_damage(hit)
        if damage == 0:
            print("Computer consiguió esquivarte!!")
            if player_life > 3:
                damage = calculate_damage(random.choice([1, 2]))
                if damage != 0:
                    print(f"Computer te ataca y te quita {damage} puntos de vida!!!\n")
                    player_life -= damage
                else:
                    print("Computer intentó golpearte pero le esquivaste!!\n")
            else:
                damage = {calculate_damage(random.choice([1, 2, 3]))}
                print(f"Computer esquivó tu golpe!!!\nComputer te ataca y te quita {damage} puntos de vida!!!\n")
                player_life -= damage
        else:
            print(f"\nComputer no consigue esquivarte y le quitas {damage} puntos de vida!!\n")
            computer_life -= damage
        if player_life > 0 and computer_life > 0:
            input("Pulsa ENTER para continuar...")
    if computer_life <= 0:
        print("GANAS LA PELEA!!!\n")
        games_summary.append(f"{player_nick} VS Computer -- WINNER -> {player_nick}")
    else:
        print("COMPUTER CONSIGUIÓ TUMBARTE!!!!!\n")
        games_summary.append(f"{player_nick} VS Computer -- WINNER -> COMPUTER")
    input("Pulsa ENTER para continuar...")

def hit_menu_1():
    print("""
    MENÚ DE ATAQUE
======================================
    1 - Puñetazo
    2 - Patada
======================================
            """)
    option = check_option(1, 2)
    return option    

def hit_menu_2():
    print("""
    MENÚ DE ATAQUE
======================================
    1 - Puñetazo
    2 - Patada
    3 - Cabezazo (Finisher)
======================================
            """)
    option = check_option(1, 3)
    return option   

def calculate_damage(hit):
    if hit == 1:
        if random.random() < 0.6:
            damage = random.randint(1, 6)
        else:
            damage = 0
    elif hit == 2:
        if random.random() < 0.4:
            damage = random.randint(4, 8)
        else:
            damage = 0
    elif hit == 3:
        if random.random() < 0.8:
            damage = random.randint(1, 9)
        else:
            damage = 0
    return damage
    
def show_summary():
    for i, game in enumerate(games_summary):
        print(f"GAME {i+1}: {game}")
    input("\nPress ENTER to continue.\n")
    
if __name__ =="__main__":
    print("\nBienvenido a...\n¡¡¡¡¡FINAL FIGHT TOURNAMENT!!!!!")
    start_menu()