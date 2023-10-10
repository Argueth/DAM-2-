package ejercicio1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Main {
	
	public static final String FILENAME = "./carta.xml";
	public static Carta carta = new Carta();
	
	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		int option = -1;
		
		while (option != 0) {
			try {
				showMenu();
				option = checkOption(enter);
				switch (option) {
					case 1:
						carta.addPizza(enter, FILENAME);
						break;
					case 2:
						carta.listPizzas(FILENAME);
						break;
					case 3:
						break;
					case 4:
						break;
					case 0:
						System.out.println("BYE!!");
						break;
					default:
						break;
				}
			} catch (InputMismatchException e) {
				System.out.println(e);
			} catch (ParserConfigurationException e) {
				System.out.println(e);
			} catch (SAXException e) {
				System.out.println(e);
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (TransformerConfigurationException e) {
				System.out.println(e);
			} catch (TransformerException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public static void showMenu() {
		
		System.out.println("""
				*****
				MENU
				*****
				=======================================
				 1. Add pizzas
				 2. List all pizzas
				 3. Remove all pizzas
				 4. Generate HTML report using XSL
				 0. Exit
				=======================================
					Select an option: 
				""");
	}
	
	public static int checkOption(Scanner enter)throws InputMismatchException, Exception  {
		int option = -1;
		if(enter.hasNextInt()) {
			option = enter.nextInt();
			if (option < 0 || option > 4) {
				throw new Exception("Invalid option. try again");
			}
		}else {
			throw new InputMismatchException("Invalid option. Try again.");
		}
		
		return option;
	}
}
