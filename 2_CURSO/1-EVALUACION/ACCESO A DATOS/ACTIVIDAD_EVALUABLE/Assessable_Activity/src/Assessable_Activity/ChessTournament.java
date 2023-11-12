package Assessable_Activity;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class ChessTournament {
	//Initialization of an ArrayList that will collect the chess tournament players. 
	ArrayList<ChessPlayer> chessTournament = new ArrayList<ChessPlayer>();
	
	/*
	 * Method to add players to the ArrayList declared above.
	 * 
	 * Player data is requested in a loop until the user enters '0' as the ID.
	 * 
	 * Id ID is '0', the method to create an XML and a CSV file with the entered player data is called.
	 */
	public void addPlayers(String XMLFILENAME, String CSVFILENAME)throws InputMismatchException, TransformerConfigurationException, TransformerException, Exception {
		while(true) {
			boolean validId;
			String playerId;
			do {
				validId = true;
				playerId = IOTools.AskString("Enter the player ID (can't contain spaces)");
				/*
				 * For each ID, it is checked whether a player with the same ID already exists.
				 * If so, a message is displayed to the user, and the user is asked to enter the ID again.
				 */
				for (ChessPlayer chessPlayer : chessTournament) {
					if(chessPlayer.getId().equals(playerId)) {
						validId = false;
						System.out.println("There is a player with this ID already. Try Again");
						break;
					}
				}
			} while (!validId);
			if(playerId.equals("0")) {
				if(chessTournament.size() != 0) {
					createDocument(XMLFILENAME, "players", chessTournament, "player");
					createCsvDocument(CSVFILENAME);
				}else {
					System.out.println("There are no registered players.");
				}
				break;
			}
			String fullName = IOTools.AskStringWhitSpaces("Enter the player's full name");
			String country = IOTools.AskStringWhitSpaces("Enter the player's country");
			float score1 = IOTools.AskForScore("Enter the player's game 1 score (0, 0.5 or 1)");
			float score2 = IOTools.AskForScore("Enter the player's game 2 score (0, 0.5 or 1)");
			float score3 = IOTools.AskForScore("Enter the player's game 3 score (0, 0.5 or 1)");
			
			chessTournament.add(new ChessPlayer(playerId, fullName, country, score1, score2, score3));
		}
	}
	
	/*
	 * Method that returns a DocumentBuilder.
	 * 
	 * I have created this method separately from the rest to use it from various sources individually,
	 * in this case, the createDocument and loadDocument methods.
	 */
	private static DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
		DocumentBuilderFactory dbfPlayers = DocumentBuilderFactory.newInstance();
		return dbfPlayers.newDocumentBuilder();
	}
	
	/*
	 * Method to create a document with a root element. From this method, the methods to fill the document 
	 * with data and to save it are called.
	 * 
	 * To make the method more flexible, I have added input parameters: a String for the root element,
	 * another String for the repeated elements within the root, and an ArrayList.
	 * 
	 * This way, I can use it to create both the XML document for ChessTournament with all tournament 
	 * players and the one for candidates with only the players who have a TotalScore of 3.0.
	 */
	private static void createDocument(String XMLFILENAME, String stRootElement, ArrayList<ChessPlayer> arrayList, String stElement) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
		
		DocumentBuilder dbPlayers = getDocumentBuilder();
		
		Document docPlayers = dbPlayers.newDocument();
		Element eRoot = docPlayers.createElement(stRootElement);
		docPlayers.appendChild(eRoot);
		
		fillDocument(docPlayers, arrayList, stElement);
		saveFile(docPlayers, XMLFILENAME, "yes");
	}
	
	/*
	 * This method takes the document and fills it with data.
	 * 
	 * Just like in the previous method, to make it more flexible, I have added the ArrayList and the
	 * repeating element within the root element as input arguments.
	 * 
	 * This way, I can use it with different lists and different elements, even though the elements within 
	 * it are always the same (id, full name, country, score1, score2, and score3).
	 */
	private static void fillDocument(Document docPlayers, ArrayList<ChessPlayer> arrayList, String stElement) {
		
		Iterator<ChessPlayer> iter = arrayList.iterator();
		while (iter.hasNext()) {
			ChessPlayer player = iter.next();
			Element objElement = docPlayers.createElement(stElement);
			docPlayers.getDocumentElement().appendChild(objElement);
			Element eNodeID = docPlayers.createElement("id");
			Text txtNode = docPlayers.createTextNode(String.valueOf(player.getId()));
			eNodeID.appendChild(txtNode);
			objElement.appendChild(eNodeID);
			Element eNodeName = docPlayers.createElement("complete_name");
			txtNode = docPlayers.createTextNode(player.getFullname());
			eNodeName.appendChild(txtNode);
			objElement.appendChild(eNodeName);
			Element eNodeCountry = docPlayers.createElement("country");
			txtNode = docPlayers.createTextNode(player.getCountry());
			eNodeCountry.appendChild(txtNode);
			objElement.appendChild(eNodeCountry);
			Element eNodeScore1 = docPlayers.createElement("score_1");
			txtNode = docPlayers.createTextNode(String.valueOf(player.getScore1()));
			eNodeScore1.appendChild(txtNode);
			objElement.appendChild(eNodeScore1);
			Element eNodeScore2 = docPlayers.createElement("score_2");
			txtNode = docPlayers.createTextNode(String.valueOf(player.getScore2()));
			eNodeScore2.appendChild(txtNode);
			objElement.appendChild(eNodeScore2);
			Element eNodeScore3 = docPlayers.createElement("score_3");
			txtNode = docPlayers.createTextNode(String.valueOf(player.getScore3()));
			eNodeScore3.appendChild(txtNode);
			objElement.appendChild(eNodeScore3);
			Element eNodeScoreTotal = docPlayers.createElement("scoreTotal");
			txtNode = docPlayers.createTextNode(String.valueOf(player.getScore1() + player.getScore2() + player.getScore3()));
			eNodeScoreTotal.appendChild(txtNode);
			objElement.appendChild(eNodeScoreTotal);
		}
	}
	
	/*
	 * Method that takes the document filled with data and saves it as an XML document.
	 * 
	 * Here, in addition to the document itself and the resulting file path, I have added a string as an input argument.
	 *  
	 * This string is used to decide whether to add a newline at the end of each line in the document.Here, 
	 * in addition to the document itself and the resulting file path, I have added a string as an input argument. 
	 * This string is used to decide whether to add a newline at the end of each line in the document.
	 * 
	 * I did this because when I used the method to modify the document, a new line break was generated after each element
	 * in the document. To control this, when I call the method from document creation, I send 'yes' as the breakline 
	 * argument, and when I call it from modification, I send 'no' as the breakline.
	 */
	private static void saveFile(Document docPlayers, String XMLFILENAME, String breakLine) throws TransformerConfigurationException, TransformerException {
		DOMSource srcPlayers = new DOMSource(docPlayers);
		StreamResult resultFile = new StreamResult(new File(XMLFILENAME));
		Transformer tfPlayers = TransformerFactory.newInstance().newTransformer();
		
		tfPlayers.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		tfPlayers.setOutputProperty(OutputKeys.INDENT, breakLine);
		tfPlayers.setOutputProperty(OutputKeys.METHOD, "xml");
		tfPlayers.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tfPlayers.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

		tfPlayers.transform(srcPlayers, resultFile);
	}
	
	//Method to get a BufferedWriter.
	private static BufferedWriter getBufferedWriter(String FILENAME) throws IOException {
		return new BufferedWriter(new FileWriter(new File(FILENAME)));
	}
	
	//Method to get BufferedReader
	private static BufferedReader getBufferedReader(String FILENAME) throws IOException {
		return new BufferedReader(new FileReader(new File(FILENAME)));
	}
	
	/*
	 * Method that uses the ArrayList with all the players to create a CSV document 
	 * using the toString method of each ChessPlayer object within the ArrayList.
	 */
	private void createCsvDocument(String CSVFILENAME) throws IOException {
		BufferedWriter bfw = getBufferedWriter(CSVFILENAME);
		
		String line = "ID,Name,Country,Score1,Score2,Score3,TotalScore\n";
		for(ChessPlayer player : chessTournament) {
			line += player.toString();
		}
		bfw.write(line);
		bfw.close();
	}
	
	//A method to display on the screen all the data of each player registered in the XML document passed as a parameter.
	public static void listPlayers(String XMLFILENAME) throws ParserConfigurationException, SAXException, FileNotFoundException, IOException  {
		if(new File(XMLFILENAME).exists()) {
			DocumentBuilder dbPlayers = getDocumentBuilder();
			Document docPlayers = dbPlayers.parse(XMLFILENAME);
			docPlayers.getDocumentElement().normalize();
			
			NodeList nlPlayers = docPlayers.getElementsByTagName("player");
			for(int i=0; i < nlPlayers.getLength(); i++) {
				Node nodePlayer = nlPlayers.item(i);
				if(nodePlayer.getNodeType() == Node.ELEMENT_NODE) {
					Element elPlayer = (Element) nodePlayer;
					System.out.println("");
					System.out.println("ID: " + elPlayer.getElementsByTagName("id").item(0).getTextContent());
					System.out.println("Name: " + elPlayer.getElementsByTagName("complete_name").item(0).getTextContent());
					System.out.println("Country: " + elPlayer.getElementsByTagName("country").item(0).getTextContent());
					System.out.println("Score1: " + elPlayer.getElementsByTagName("score_1").item(0).getTextContent());
					System.out.println("Score2: " + elPlayer.getElementsByTagName("score_2").item(0).getTextContent());
					System.out.println("Score3: " + elPlayer.getElementsByTagName("score_3").item(0).getTextContent());
					System.out.println("Total Score: " + elPlayer.getElementsByTagName("scoreTotal").item(0).getTextContent());
					System.out.println("");
				}
			}
		}else {
			throw new FileNotFoundException("XML file nor found.");
		}
	}
	
	//Method that creates an HTML document from an XML and an XSL template for that document.
	public static void createHtmlDocument(String XMLFILENAME, String XSLFILENAME, String HTMLFILENAME) throws FileNotFoundException, IOException, TransformerException {
		if(new File(XMLFILENAME).exists() && new File(XSLFILENAME).exists()) {
			Source stsPlayersXML = new StreamSource(XMLFILENAME);
			Source stsPlayersXSL = new StreamSource(XSLFILENAME);
			FileWriter fw = new FileWriter(HTMLFILENAME);
			StringWriter stwHTML = new StringWriter();
			
			TransformerFactory tfPlayers = TransformerFactory.newInstance();
			Transformer tfPlayersXSL = tfPlayers.newTransformer(stsPlayersXSL);
			tfPlayersXSL.transform(stsPlayersXML, new StreamResult(stwHTML));
			fw.write(stwHTML.toString());
			fw.close();
			System.out.println("");
			System.out.println("==> File "+HTMLFILENAME+" generated using "+XSLFILENAME);
		}else {
			throw new FileNotFoundException("XML file or XSL file not found");
		}
	}
	
	//Method that uses the getDocumentBuilder method to obtain a DocumentBuilder and then uses it to return a document.
	private static Document loadDocument(String XMLFILENAME) throws ParserConfigurationException, SAXException, IOException {
		return getDocumentBuilder().parse(new File(XMLFILENAME));
	}
	
	/*
	 * Method to take the new variables and modify the XML and CSV files. 
	 * 
	 * First, the user is asked for the values of the user's ID, the game for which they want to modify the score, 
	 * and the new score.
	 * 
	 * Then, the methods modifyXMLRatingPlayerGame and modifyCSVRatingPlayerGame are called, and the file path to 
	 * be modified, as well as the values of the variables mentioned earlier, are passed to them.
	 */
	public static void getDataForModifyRatingPlayerGame(String XMLFILENAME, String CSVFILENAME) throws ParserConfigurationException, TransformerException, SAXException, FileNotFoundException, IOException, Exception {
		if(new File(XMLFILENAME).exists() && new File(CSVFILENAME).exists()) {
			String stIdAsked = IOTools.AskString("Enter the player's ID");
			int intGameAsked = IOTools.AskInt("Enter the namber os score wich you want change", 1, 3);
			float flNewScoreAsked = IOTools.AskForScore("Enter the player's game 1 score (0, 0.5 or 1)");
		
			modifyXMLRatingPlayerGame(XMLFILENAME, stIdAsked, intGameAsked, flNewScoreAsked);
			modifyCSVRatingPlayerGame(CSVFILENAME, stIdAsked, intGameAsked, flNewScoreAsked);			
		}else {
			throw new FileNotFoundException("CSV file or XML file not found");
		}
	}
	
	/*
	 * Method to modify a player's score in a game and the total score of that player.
	 * 
	 * The user is asked for the player's ID, the game number for which they want to change the score, and the new score.
	 * 
	 * If the ID doesn't exist within the document, a message is displayed in the console.
	 * 
	 * If the ID exists within the document, a for loop is used to iterate through the scores of the 3 games. Then, if it 
	 * matches the game number for which the score is to be changed, it is updated and added to the totalScore. If it 
	 * doesn't match, it's simply added to the totalScore.
	 * 
	 * Finally, the totalScore is modified.
	 */
	public static void modifyXMLRatingPlayerGame(String XMLFILENAME, String stIdAsked, int intGameAsked, float flNewScoreAsked)throws ParserConfigurationException, TransformerException, SAXException, FileNotFoundException, IOException, Exception {
		
		if(new File(XMLFILENAME).exists()) {
			Document docPlayers = loadDocument(XMLFILENAME);
			NodeList nlPlayers = docPlayers.getElementsByTagName("player");
			
			int cont = 0;
			for(int i = 0; i < nlPlayers.getLength(); i++) {
				Element elPlayerElement = (Element) nlPlayers.item(i);
				Element elPlayerIdElement = (Element) elPlayerElement.getElementsByTagName("id").item(0);
				String stPlayerId = elPlayerIdElement.getTextContent();
				float flNewTotalScore = 0;
				if(stPlayerId.equalsIgnoreCase(stIdAsked)) {
					cont += 1;
					for(int j = 1; j <= 3; j++) {
						Element elPlayerScore = (Element) elPlayerElement.getElementsByTagName("score_" + String.valueOf(j)).item(0);
						if(j != intGameAsked) {
							float flScore = Float.parseFloat(elPlayerScore.getTextContent());
							flNewTotalScore += flScore;
						}else {
							elPlayerScore.setTextContent(String.valueOf(flNewScoreAsked));
							flNewTotalScore += flNewScoreAsked;
						}
					}
					Element elPlayerTotalScoreElement = (Element) elPlayerElement.getElementsByTagName("scoreTotal").item(0);
					elPlayerTotalScoreElement.setTextContent(String.valueOf(flNewTotalScore));
					break;
				}
			}
			if(cont == 0) {
				System.out.println("Player not found.");
			}else {
				saveFile(docPlayers, XMLFILENAME, "no");			
			}
		}else {
			throw new FileNotFoundException("XML file not found.");
		}
	}
	
	/*
	 * Method to modify the score of one of the player's games with a new score.
	 * 
	 * First, I create a BufferedReader by calling the getBufferedReader method with the file path received by this function.
	 * 
	 * Then, I initialize a counter, an empty string that will store the new CSV and the line collected from the 
	 * BufferedReader.
	 * 
	 * Within the loop, I iterate through the existing CSV file line by line, splitting them by "," to check if the player's 
	 * ID in that line matches the one for whom the score needs to be changed.
	 * 
	 * If id matches, I modify the score of the game that was intended to be changed to the new score. Then, I reassemble the 
	 * pieces into the 'line' variable and add it to the new CSV and I increment the counter by 1..
	 * 
	 * If the ID does not match, I simply reassemble the line and add it to the new CSV.
	 * 
	 * When I exit the loop, I close the BufferedReader and open a BufferedWriter by calling the getBufferedWriter method 
	 * to overwrite the file with the content of the 'stNewCsv' variable.
	 * 
	 * Finally, I check the counter: if it is 0, it means that there is no player with the specified ID, and this 
	 * is indicated to the user via the console.
	 * 
	 * If it is not zero, the file is overwritten with the new CSV, and the BufferedWriter is closed.
	 */
	public static void modifyCSVRatingPlayerGame(String CSVFILENAME, String stIdAsked, int intGameAsked, float flNewScoreAsked) throws FileNotFoundException, IOException {
		if(new File(CSVFILENAME).exists()) {
			BufferedReader bfr = getBufferedReader(CSVFILENAME);
			
			int cont = 0;
			String stNewCsv = "";
			String line;
			while((line = bfr.readLine()) != null) {
				String[] stData = line.split(",");
				if(stData[0].equalsIgnoreCase(stIdAsked)) {
					cont++;
					stData[2 + intGameAsked] = String.valueOf(flNewScoreAsked);
					stData[6] = String.valueOf(Float.parseFloat(stData[3]) + Float.parseFloat(stData[4]) + Float.parseFloat(stData[5]));
					line = stData[0] + "," + stData[1] + "," + stData[2] + "," + stData[3] + "," + stData[4] + "," + stData[5] + "," + stData[6] + "\n";
					stNewCsv += line;
				}else {
					line = stData[0] + "," + stData[1] + "," + stData[2] + "," + stData[3] + "," + stData[4] + "," + stData[5] + "," + stData[6] + "\n";
					stNewCsv += line;
				}
			}
			bfr.close();
			BufferedWriter bfw = getBufferedWriter(CSVFILENAME);
			if(cont == 0) {
				System.out.println("There is no players with this ID.");
			}
			bfw.write(stNewCsv);	
			bfw.close();
		}else {
			throw new FileNotFoundException("CSV file not found.");
		}
	}
	
	/*
	 * A method to create an XML document from a CSV file and an HTML document from the XML created using an XSL template.
	 * 
	 * An ArrayList is instantiated for the candidates.
	 * 
	 * A counter is initialized to 0.
	 * 
	 * It reads the CSV file line by line and checks if the totalScore is 3.0. If it is, it saves the data from that line 
	 * into a new ChessPlayer, which is then stored in the ArrayList of candidates.
	 * 
	 * With each candidate found in the document whose totalScore is 3.0, the counter is increased by 1.
	 * 
	 * If, at the end of the document, the counter is zero, a message is displayed on the screen indicating that 
	 * there are no candidates.
	 * 
	 * If not, the createDocument and createHTMLDocument methods are used to generate an XML document and an HTML 
	 * document from the XML created and a CSV template.
	 */
	public static void createCandidatesXML(String CSVFILENAME, String XMLCANDIDATESFILENAME, String XSLCANDIDATESFILENAME, String HTMLCANDIDATESFILENAME) throws FileNotFoundException, TransformerException, ParserConfigurationException, IOException {
		ArrayList<ChessPlayer> candidates = new ArrayList<ChessPlayer>();
		
		if(new File(CSVFILENAME).exists()) {			
			BufferedReader br = getBufferedReader(CSVFILENAME);
			
			String line;
			int cont = 0;
			while((line = br.readLine()) != null) {
				String[] stPlayerData = line.split(",");
				if (stPlayerData[6].equals("3.0")) {
					candidates.add(new ChessPlayer(stPlayerData[0], stPlayerData[1], stPlayerData[2], Float.parseFloat(stPlayerData[3]), Float.parseFloat(stPlayerData[4]), Float.parseFloat(stPlayerData[5])));
					cont += 1;
				}
			}
			if(cont == 0) {
				System.out.println("There is no candidates for Chess Master.");
			}else {
				createDocument(XMLCANDIDATESFILENAME, "candidates", candidates, "candidate");
				createHtmlDocument(XMLCANDIDATESFILENAME, XSLCANDIDATESFILENAME, HTMLCANDIDATESFILENAME);
			}
		}else {
			throw new FileNotFoundException("CSV file not found.");
		}
	}
}
