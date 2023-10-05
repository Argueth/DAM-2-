package Main;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.NonReadableChannelException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		mostrarMenu();
		
	}
	
	public static void mostrarMenu() {
		
		Scanner entrada = new Scanner(System.in);
		int opcion = -1;
		do {
			try {
				System.out.println("""
						**************************************************
						*             MENU DE OPCIONES                   *
						*                                                *
						*    1.- Ver lista de archivos                   *
						*    2.- Buscar archivo por extensión            *
						*    3.- Ver última fecha de modificación        *
						*    4.- Ver tamaño de un archivo                *
						*    5.- Escribir en un archivo                  *
						*    6.- Leer un archivo linea por linea         *
						*    7.- Buscar palabra mas larga de un archivo  *
						*                                                *
						*    0.- Salir                                   *
						*                                                *
						**************************************************
						""");
				
				opcion = comprobarOpcion(entrada);
				entrada.nextLine();
				System.out.print("Introduce la ruta deseada: ");
				String ruta = entrada.nextLine();
				File archivo = new File(ruta);
					
				switch (opcion) {
					case 1:
						mostrarArchivos(archivo);
						break;
					case 2:
						ArrayList lista2 = listArchivos(archivo);
						buscarExtension(entrada, lista2);
						break;
					case 3:
						ultimaModificacion(archivo);
						break;
					case 4:
						tamaño(archivo);
						break;
					case 5:
						escribir(entrada, archivo);
						break;
					case 6:
						linaPorLinea(archivo);
						break;
					case 7:
						palabraMasLarga(archivo);
						break;
					case 0:
						System.out.println("BYE!!");
					default:
						break;
				}	
						
			} catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado.");
			}catch (InputMismatchException e) {
				System.out.println(e);
			}catch (IOException e) {
				System.out.println(e);
			}catch (Exception e) {
				System.out.println(e);
			}
		} while (opcion != 0);
			
	}
	
	public static int comprobarOpcion(Scanner entrada) throws InputMismatchException {
		boolean valido = false;
		int opcion = -1;
		do {
			System.out.println("Elija una de las opciones: ");
			
			if(entrada.hasNextInt()) {
				opcion = entrada.nextInt();
				if (opcion >= 0 || opcion <= 7) {
					valido = true;
				}
			}
			
		} while (valido == false);
		
		return opcion;
	}
	
	public static void mostrarArchivos(File archivo) throws IOException, FileNotFoundException, Exception {
		if (archivo.isDirectory()) {
			for (File x : archivo.listFiles()) {
				System.out.println(archivo.getName());
			}
		}else if (archivo.isFile()) {
			System.out.println("La ruta corresponde a un archivo.");
		}else {
			throw new FileNotFoundException("Archivo no encontrado.");
		}
	}
	
	public static ArrayList listArchivos(File archivo)throws IOException {
		ArrayList<File> lista = new ArrayList();
		if(archivo.isDirectory()) {
			for (File x : archivo.listFiles()) {
				lista.add(x);
			}
		}else {
			System.out.println("La ruta especificada no corresponde a un directorio.");
		}
			
		
		return lista;
	}
	
	public static void buscarExtension(Scanner entrada, ArrayList lista)throws IOException {
		System.out.println("Introduce la extensión a buscar: ");
		String extension = entrada.nextLine();
		int cont = 0;
		Iterator iter = lista.iterator();
		while (iter.hasNext()) {
			File archivo = (File) iter.next();
			if (archivo.getName().toLowerCase().endsWith(extension)) {
				System.out.println(archivo.getName());
			}	
		}
		if (cont == 0) {
			System.out.println("No hay ningún archivo con la extensión especificada.");
		}
	}
	
	public static boolean existencia(File archivo) throws IOException {
		boolean existe = false;
		if (archivo.exists()) {
			existe = true;
		}else {
			System.out.println("El archivo no existe.");
		}
		
		return existe;
	}
	
	public static void ultimaModificacion(File archivo) throws IOException, Exception {
		if(archivo.isFile()) {
			Date lastModifieDate = new Date(archivo.lastModified());
			System.out.println("La última fecha de modificación del archivo es " + lastModifieDate);
		}else {
			throw new Exception("La ruta lleva a un direcotorio.");
		}
			
	}
	
	public static void tamaño(File archivo) throws IOException, Exception {
		if(archivo.isFile()) {
			long tamañoBytes = archivo.length();
			double tamañoKB = tamañoBytes / 1024f;
			double tamañoMB = tamañoKB / 1024f;
			
			System.out.printf("""
					Tamaño en Bytes: %d
					Tamaño en KiloBytes: %f
					Tamaño en MegaBytes: %f
					""", tamañoBytes, tamañoKB, tamañoMB);
		}else {
			throw new Exception ("La ruta lleva a un directorio.");
		}
			
	}
	
	public static void linaPorLinea(File archivo) throws IOException, Exception {
		if (archivo.isFile()) {
			FileReader lector = new FileReader(archivo);
			BufferedReader br = new BufferedReader(lector);
			
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		}else {
			throw new Exception("La ruta lleva a un directorio");
		}
			
	}
	
	public static void escribir(Scanner entrada, File archivo) throws IOException, Exception{
		if (archivo.isFile()) {
			FileWriter escritor = new FileWriter(archivo, true); //true para escribir al final del contenido del archivo.
			
			System.out.println("Introduce el texo a incluir: ");
			String texto = entrada.nextLine();
			
			escritor.write("\n" + texto);
			escritor.close();
		}else {
			throw new Exception("La ruta lleva a un directorio");
		}
			
	}
	
	public static void palabraMasLarga(File archivo) throws IOException, Exception {
		if (archivo.isFile()) {
			FileReader lector = new FileReader(archivo);
			BufferedReader br = new BufferedReader(lector);
			
			String linea;
			String masLarga = "";
			while ((linea = br.readLine()) != null) {
				String[] palabras = linea.split(" ");
				for (String palabra : palabras) {
					palabra = palabra.replaceAll("[^a-zA-Z]", " ");
					if (palabra.length() > masLarga.length()) {
						masLarga = palabra;
					}
				}
			}
			System.out.println("La palabra más larga del documento es " + masLarga);
		}else {
			throw new Exception ("La ruta lleva a un directorio.");
		}
			
	}
}
