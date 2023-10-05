package ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int option = -1;
		ShoppingCart cart = new ShoppingCart();
		File file = new File("./ShoppingCart.txt");
		
		do {
			try {
				showMenu();
				option = checkOption(entrada);
				
				switch(option) {
				case 1:
					cart.addProduct(file);
					break;
				case 2:
					cart.listProducts(file);
					break;
				case 3:
					cart.removeProducts(file);
					break;
				case 0:
					System.out.println("BYE!!");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println(e);
			}catch (IOException e) {
				System.out.println(e);
			}catch (Exception e) {
				System.out.println(e);
			}
		} while (option != 0);
	}
	
	public static void showMenu() {
			System.out.println("""
					************************
					Choose an option
					************************
					1. Add Products
					2. List all Products
					3. REmove all Products
					0. Exit
					************************
					""");
	}
	
	public static int checkOption(Scanner entrada) throws InputMismatchException, Exception {
		boolean valid = false;
		int option = -1;
		option = entrada.nextInt();
		if (option >= 0 && option <= 3) {
			valid = true;
		}else {
			throw new Exception("Invalid option. Try again.");
		}	
			
		return option;
	}
}
