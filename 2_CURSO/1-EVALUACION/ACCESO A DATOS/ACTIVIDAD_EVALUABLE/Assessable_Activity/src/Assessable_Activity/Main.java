package Assessable_Activity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Main {
	//Declaration and initialization of constants with the file addresses.
	public static final String XMLFILENAME = "./ChessTorunament.xml";
	public static final String CSVFILENAME = "./ChessTournament.csv";
	public static final String XSLFILENAME = "./ChessTournament.xsl";
	public static final String HTMLFILENAME = "./ChessTournament.html";
	public static final String XMLCANDIDATESFILENAME = "./candidates.xml";
	public static final String XSLCANDIDATESFILENAME = "./candidates.xsl";
	public static final String HTMLCANDIDATESFILENAME = "./candidates.html";
	
	//Method that initializes the application.
	public static void main(String[] args) {
		//An object of type ChessTournament is created.
		ChessTournament chessT = new ChessTournament();
		int option = -1;
		while(option != 0) {
			showMenu();
			//Try block where I collect all exceptions from the entire application to centralize their control.
			try {
				option = IOTools.AskInt("Select and option", 0, 5);
				switch (option) {
				case 1:
					chessT.addPlayers(XMLFILENAME, CSVFILENAME);
					break;
				case 2:
					ChessTournament.listPlayers(XMLFILENAME);
					break;
				case 3:
					ChessTournament.createHtmlDocument(XMLFILENAME, XSLFILENAME, HTMLFILENAME);
					break;
				case 4:
					ChessTournament.getDataForModifyRatingPlayerGame(XMLFILENAME, CSVFILENAME);
					break;
				case 5:
					ChessTournament.createCandidatesXML(CSVFILENAME, XMLCANDIDATESFILENAME, XSLCANDIDATESFILENAME, HTMLCANDIDATESFILENAME);
					break;
				case 0:
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
				e.printStackTrace();
			}
			if(option != 0) {
				IOTools.pressAnyKey();				
			}
		}
		System.out.println("BYE!!");
	}
	
	//Method to show the Menu in console.
	public static void showMenu() {
		System.out.println("""
				*****
				MENU
				*****
				=========================================================
				 1. Get chess players and scores (to CSV & XML)
				 2. List all chess players
				 3. Generate HTML with all chess players vis XSL
				 4. Modify the rating of a chess player's game
				 5. Generate HTML with chess master candidates via XSL
				 
				 0. Exit
				=========================================================
				""");
	}

}
