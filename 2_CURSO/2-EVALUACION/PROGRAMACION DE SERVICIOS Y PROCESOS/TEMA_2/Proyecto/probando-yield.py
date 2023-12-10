def player_name():
    i = 1
    while True:
        yield f"Player{i}"
        i+=1

if __name__ == "__main__":
    name_generator = player_name()
    while True:
        input("Press ENTER to get a name")
        print(next(name_generator))