package Ejercicio2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Main {
	
	public static final String FILENAME = "./animals.xml";
	public static final String REPORT_FILENAME = "./reportAnimals.xsl";
	public static Clinic clinic = new Clinic();
	
	public static void main(String[] args) {
		
		Scanner enter = new Scanner(System.in);
		int option = -1;
		
		while (option != 0) {
			try {
				showMenu();
				option = checkOption(enter);
				enter.nextLine();
				
				switch (option) {
				case 1:
					clinic.addAnimals(enter, FILENAME);
					break;
				case 2:
					Clinic.listAnimals(FILENAME);
					break;
				case 3:
					Clinic.changeSterilisedForBreed(enter, FILENAME);
					break;
				case 4:
					Clinic.ChangeSterilisedForNonAdults(enter, FILENAME);
					break;
				case 5:
					Clinic.deleteFile(FILENAME);
					break;
				case 6:
					Clinic.xslGenerate(REPORT_FILENAME);
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
				===========================================
				  1. Add animals
				  2. List all animals
				  3. Sterilise a specific breed
				  4. Sterilise non-adults
				  5. Remove all animals
				  6. Generate HTML report using XSL
				  0. Exit
				===========================================
				""");
		System.out.print("Select an option: ");
	}
	
	public static int checkOption(Scanner enter)throws InputMismatchException, Exception  {
		int option = -1;
		String message = "Invalid option. Try again.";
		if(enter.hasNextInt()) {
			option = enter.nextInt();
			if (option < 0 || option > 6) {
				throw new Exception(message);
			}
		}else {
			throw new InputMismatchException(message);
		}
		
		return option;
	}

}
