package Ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Clinic {
	
	ArrayList<Animal> animals = new ArrayList<Animal>();
	
	public void addAnimals(Scanner enter, String FILENAME) throws InputMismatchException, TransformerConfigurationException, TransformerException, Exception {
		
		while (true) {
			System.out.print("Enter the animal's ID: ");
			int intId = askForInt(enter, "ID");
			if(intId == 0) {
				createDocument(FILENAME);
				break;
			}
			String stName = askForStringWithSpaces(enter, "name");
			String stSpecies = askForStringWithoutSpaces(enter, "species");
			String stBreed = askForStringWithSpaces(enter, "breed");
			int intAge = askForInt(enter, "age");
			String stSterilised = askForStringWithoutSpaces(enter, "sterilised");
			if(!stSterilised.equalsIgnoreCase("yes") && !stSterilised.equalsIgnoreCase("no")) {
				throw new Exception("Invalid value for Sterilised.");
			}
			animals.add(new Animal(intId, stName, stSpecies, stBreed, intAge, stSterilised));
		}
	}
	
	private static int askForInt(Scanner enter, String askFor) throws InputMismatchException {
		int num;
		System.out.print(String.format("Enter the animal's %s: ", askFor));
		if(enter.hasNextInt()) {
			num = enter.nextInt();
			enter.nextLine();
		}else {
			enter.nextLine();
			throw new InputMismatchException(String.format("Invalid %s", askFor));
		}
		return num;
	}
	
	private static String askForStringWithSpaces(Scanner enter, String askFor) throws Exception {
		String string;
		System.out.print(String.format("Enter the animal's %s: ", askFor));
		string = enter.nextLine();
		if(string.equals("")) {
			throw new Exception(String.format("Invalid animal's %s", askFor));
		}
		return string;
	}
	
	private static String askForStringWithoutSpaces(Scanner enter, String askFor) throws Exception {
		String string;
		System.out.print(String.format("Enter the animal's %s: ", askFor));
		string = enter.nextLine();
		if(string.equals("") || string.split(" ").length > 1) {
			throw new Exception(String.format("Invalid animal's %s", askFor));
		}
		return string;
	}

	private static DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
		DocumentBuilderFactory dbfAnimals = DocumentBuilderFactory.newInstance();
		return dbfAnimals.newDocumentBuilder();
	}
	
	private void createDocument(String FILENAME) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
		
		DOMImplementation domImplement = getDocumentBuilder().getDOMImplementation();
		Document docAnimals = domImplement.createDocument(null, "animals", null);
		docAnimals.setXmlVersion("1.0");
		
		//Insertar la línea del stylesheet
		ProcessingInstruction pi = docAnimals.createProcessingInstruction("xml-stylesheet", "type='text/xsl' href='./reportAnimals.xsl'");
		docAnimals.insertBefore(pi, docAnimals.getDocumentElement());
		
		fillDocument(docAnimals);
		saveFile(docAnimals, FILENAME, "yes");
	}
	
	private void fillDocument(Document docAnimals) {
	    
		Iterator<Animal> iter = animals.iterator();
		while (iter.hasNext()) {
			Animal animal = iter.next();
			Element objElement = docAnimals.createElement("animal");
			docAnimals.getDocumentElement().appendChild(objElement);
			Element eNodeID = docAnimals.createElement("id");
			Text txtNode = docAnimals.createTextNode(String.valueOf(animal.getIntId()));
			eNodeID.appendChild(txtNode);
			objElement.appendChild(eNodeID);
			Element eNodeName = docAnimals.createElement("name");
			txtNode = docAnimals.createTextNode(animal.getStName());
			eNodeName.appendChild(txtNode);
			objElement.appendChild(eNodeName);
			Element eNodeSpecies = docAnimals.createElement("species");
			txtNode = docAnimals.createTextNode(animal.getStSpecies());
			eNodeSpecies.appendChild(txtNode);
			objElement.appendChild(eNodeSpecies);
			Element eNodeBreed = docAnimals.createElement("breed");
			txtNode = docAnimals.createTextNode(animal.getStBreed());
			eNodeBreed.appendChild(txtNode);
			objElement.appendChild(eNodeBreed);
			Element eNodeAge = docAnimals.createElement("age");
			txtNode = docAnimals.createTextNode(String.valueOf(animal.getIntAge()));
			eNodeAge.appendChild(txtNode);
			objElement.appendChild(eNodeAge);
			Element eNodeSterilised = docAnimals.createElement("sterilised");
			txtNode = docAnimals.createTextNode(animal.getStSterilised());
			eNodeSterilised.appendChild(txtNode);
			objElement.appendChild(eNodeSterilised);
		}
	}
	
	private static void saveFile(Document docAnimals, String FILENAME, String breakLine) throws TransformerConfigurationException, TransformerException {
		Source srcAnimal = new DOMSource(docAnimals);
		Result resultFile = new StreamResult(new File(FILENAME));
		Transformer transfAnimals = TransformerFactory.newInstance().newTransformer();
		
		transfAnimals.setOutputProperty(OutputKeys.INDENT, breakLine);
	    transfAnimals.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // Define la cantidad de espacios para la sangría

		transfAnimals.transform(srcAnimal, resultFile);
	}
	
	public static void listAnimals(String FILENAME) throws ParserConfigurationException, SAXException, FileNotFoundException, IOException {
		System.out.println("");
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		
		SAXParser saxParser = saxFactory.newSAXParser();
		PrintAllHandlerSaxAnimals saxHandler = new PrintAllHandlerSaxAnimals();
		saxParser.parse(FILENAME, saxHandler);
	}
	
	public static void deleteFile(String FILENAME) throws FileNotFoundException, IOException {
		File file = new File(FILENAME);
		if (file.exists()) {
			if(file.delete()) {
				System.out.println("File succesfully deleted.");
			}else {
				throw new IOException("Delete file error.");
			}
		}else {
			throw new FileNotFoundException("The file does not exist at the specified path.");
		}	
	}
	
	private static Document loadDocument(String FILENAME) throws ParserConfigurationException, SAXException, IOException {
		return getDocumentBuilder().parse(new File(FILENAME));
	}
	
	public static void changeSterilisedForBreed(Scanner enter, String FILENAME) throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		Document docAnimals = loadDocument(FILENAME);
		NodeList nlAnimalList = docAnimals.getElementsByTagName("animal");
		
		String stSpeciesAsked = askForStringWithoutSpaces(enter, "breed");
		
		for (int i = 0; i < nlAnimalList.getLength(); i++) {
			Element elAnimalElement = (Element) nlAnimalList.item(i);
			Element elBreedElement = (Element) elAnimalElement.getElementsByTagName("breed").item(0);
			String stBreed = elBreedElement.getTextContent();
			
			if(stBreed.equalsIgnoreCase(stSpeciesAsked)) {
				Element elSterilisedElement = (Element) elAnimalElement.getElementsByTagName("sterilised").item(0);
				elSterilisedElement.setTextContent("yes");
			}
		}
		saveFile(docAnimals, FILENAME, "no");
	}
	
	public static void ChangeSterilisedForNonAdults(Scanner enter, String FILENAME) throws ParserConfigurationException, TransformerException, Exception {
		Document docAnimals = loadDocument(FILENAME);
		NodeList nlAnimalList = docAnimals.getElementsByTagName("animal");
		
		for (int i = 0; i < nlAnimalList.getLength(); i++) {
			Element elAnimalElement = (Element) nlAnimalList.item(i);
			Element elAgeElement = (Element) elAnimalElement.getElementsByTagName("age").item(0);
			String stSpecies = elAgeElement.getTextContent();
			
			if(Integer.parseInt(stSpecies) < 2) {
				Element elSterilisedElement = (Element) elAnimalElement.getElementsByTagName("sterilised").item(0);
				elSterilisedElement.setTextContent("yes");
			}
		}
		saveFile(docAnimals, FILENAME, "no");
	}
	
	public static void xslGenerate(String REPORT_FILENAME) throws IOException {
		String xsltContent = """
				<?xml version=\"1.0\" encoding=\"UTF-8\"?>
				<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
					<xsl:template match="/">
						<html>
							<head>
								<title>MENU DE PIZZAS</title>
							</head>
							<body>
								<h1>LIST OF ANIMALS</h1>
								<table border="1">
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Species</th>
										<th>Breed</th>
										<th>Age</th>
										<th>Sterilised</th>
									</tr>
									<xsl:for-each select="animals/animal">
										<tr>
											<td><xsl:value-of select="id"/></td>
					          				<td><xsl:value-of select="name"/></td>
					          				<td><xsl:value-of select="species"/></td>
					          				<td><xsl:value-of select="breed"/></td>
					          				<td><xsl:value-of select="age"/></td>
					          				<td><xsl:value-of select="sterilised"/></td>
										</tr>
									</xsl:for-each>
								</table>
							</body>
						</html>
					</xsl:template>
				</xsl:stylesheet>
				""";
		File fReport = new File(REPORT_FILENAME);
		FileWriter fwWriter = new FileWriter(fReport);
		BufferedWriter bfWriter = new BufferedWriter(fwWriter); 
		bfWriter.write(xsltContent);
		bfWriter.close();
		fwWriter.close();
	}
}
