package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShoppingCart {
	ArrayList<Product> cart = new ArrayList<>();
	
	public void addProduct(File file) throws IOException, InputMismatchException, Exception {
		Scanner enter = new Scanner(System.in);
			
		while (true) {
			System.out.print("Enter the product name: ");
			String strName = enter.next();
			if (strName.equals("")) {
				throw new Exception("Incorrect product name.");
			}
			
			if (strName.equalsIgnoreCase("zero")) {
				saveProductsToFile(file);
				break;
			}
			
			double dbPrice;
			System.out.print("Enter product Price: ");
			if (enter.hasNextDouble()) {
				dbPrice = enter.nextDouble();
			}else {
				throw new InputMismatchException("Incorrect price format");
			}
			
			int intUnits;
			System.out.print("Enter the number of units: ");
			if (enter.hasNextInt()) {
				intUnits = enter.nextInt();
			}else {
				throw new InputMismatchException("Incorrect units format");
			}
			
			cart.add(new Product(strName, dbPrice, intUnits));
		}		
	}
	
	public void listProducts(File file) throws Exception {
		if(file.exists()) {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while((line=br.readLine()) != null)
				System.out.println(line);
			
			br.close();
			fr.close();
		}else {
			throw new Exception("Shopping list is empty.");
		}
	}
	
	public void removeProducts(File file) throws IOException {
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("List deleted.");
			}else {
				throw new IOException("The file could not be delete.");
			}
		}else {
			throw new IOException("The file doesn't exists.");
		}	
	}
	
	private void saveProductsToFile(File file) throws IOException {
		String text = "";
		
		for (Product product : cart) {
			text += product.toString() + "\n";
		}
		FileWriter writer = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write(text);
		bw.close();
	}
}
