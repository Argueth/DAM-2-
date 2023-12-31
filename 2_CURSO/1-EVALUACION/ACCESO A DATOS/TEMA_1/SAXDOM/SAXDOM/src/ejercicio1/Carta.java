package ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;

public class Carta {
	ArrayList<Pizza> carta = new ArrayList<Pizza>();
	
	public void addPizza(Scanner enter, String FILENAME) throws InputMismatchException, TransformerConfigurationException, TransformerException, Exception {
		
		while (true) {
			System.out.println("Enter the Pizza's ID: ");
			int intId;
			if(enter.hasNextInt()) {
				intId = enter.nextInt();
				enter.nextLine();
			}else {
				enter.nextLine();
				throw new InputMismatchException("Invalid ID.");
			}
			if(intId == 0) {
				createDocument(FILENAME);
				break;
			}
			String stName;
			System.out.println("Enter the pizza's name: ");
			stName = enter.nextLine();
			if (stName.equals("")) {
				throw new Exception("Invalid product name.");
			}
			double dbPrice;
			System.out.println("Enter the pizza's price: ");
			if(enter.hasNextDouble()) {
				dbPrice = enter.nextDouble();
				enter.nextLine();
			}else {
				enter.nextLine();
				throw new InputMismatchException("Invalid price.");
			}
			
			carta.add(new Pizza(intId, stName, dbPrice));
		}
	}
	
	public void listPizzas(String FILENAME) throws ParserConfigurationException, SAXException, FileNotFoundException, IOException {
		System.out.println("");
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		
		SAXParser saxParser = saxFactory.newSAXParser();
		PrintAllHandlerSax saxHandler = new PrintAllHandlerSax();
		saxParser.parse(FILENAME, saxHandler);
	}
	
	private void createDocument(String FILENAME) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
		DocumentBuilderFactory dbfPizzas = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbPizzas = dbfPizzas.newDocumentBuilder();
		
		DOMImplementation domImplement = dbPizzas.getDOMImplementation();
		Document docPizzas = domImplement.createDocument(null, "pizzas", null);
		docPizzas.setXmlVersion("1.0");
		
		fillDocument(docPizzas);
		saveFile(docPizzas, FILENAME);
	}
	
	private void fillDocument(Document docPizzas) {
		//Insertar la línea del stylesheet
		ProcessingInstruction pi = docPizzas.createProcessingInstruction("xml-stylesheet", "type='text/xsl' href='./report.xsl'");
	    docPizzas.insertBefore(pi, docPizzas.getDocumentElement());
	    
		Iterator iter = carta.iterator();
		while (iter.hasNext()) {
			Pizza pizza = (Pizza) iter.next();
			Element objElement = docPizzas.createElement("pizza");
			docPizzas.getDocumentElement().appendChild(objElement);
			Element eNodeID = docPizzas.createElement("id");
			Text txtNode = docPizzas.createTextNode(String.valueOf(pizza.getId()));
			eNodeID.appendChild(txtNode);
			objElement.appendChild(eNodeID);
			Element eNodeName = docPizzas.createElement("name");
			txtNode = docPizzas.createTextNode(pizza.getName());
			eNodeName.appendChild(txtNode);
			objElement.appendChild(eNodeName);
			Element eNodePrice = docPizzas.createElement("price");
			txtNode = docPizzas.createTextNode(String.valueOf(pizza.getPrice()));
			eNodePrice.appendChild(txtNode);
			objElement.appendChild(eNodePrice);
		}
	}
	
	private void saveFile(Document docPizzas, String FILENAME) throws TransformerConfigurationException, TransformerException {
		Source srcPizza = new DOMSource(docPizzas);
		Result resultFile = new StreamResult(new File(FILENAME));
		Transformer transfPizzas = TransformerFactory.newInstance().newTransformer();
		
		transfPizzas.setOutputProperty(OutputKeys.INDENT, "yes");
	    transfPizzas.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // Define la cantidad de espacios para la sangría

		transfPizzas.transform(srcPizza, resultFile);
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
								<h1>MENU DE PIZZAS</h1>
								<table border="1">
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Price</th>
									</tr>
									<xsl:for-each select="pizzas/pizza">
										<tr>
											<td><xsl:value-of select="id"/></td>
					          				<td><xsl:value-of select="name"/></td>
					          				<td><xsl:value-of select="price"/></td>
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
