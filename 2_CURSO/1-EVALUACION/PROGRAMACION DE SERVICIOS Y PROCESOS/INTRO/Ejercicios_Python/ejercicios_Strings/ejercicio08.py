precio = input("Introduce el precio del producto con dos decimales: ")

print(f"{precio[:precio.find('.')]} euros y {precio[precio.find('.')+1:]} céntimos.")