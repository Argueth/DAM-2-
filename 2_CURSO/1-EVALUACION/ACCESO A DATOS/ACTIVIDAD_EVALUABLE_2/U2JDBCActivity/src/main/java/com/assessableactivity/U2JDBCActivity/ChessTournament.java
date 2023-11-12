package com.assessableactivity.U2JDBCActivity;

import java.sql.*;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoDatabase;

public class ChessTournament {
	
	static final String DBNAME = "./ChessTournament.db";
	static final String URL = "jdbc:sqlite:" + DBNAME;
	
	public void addPlayers() {
		//Initialization of an ArrayList that will collect the chess tournament players. 
		ArrayList<ChessPlayer> chessTournament = new ArrayList<ChessPlayer>();
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
					Connection cnDB = SQLConnection.getConnectionSqlLite(URL);
					Statement staSQLquery = SQLConnection.getStatementSqlLite(cnDB);
					createTablePlayersSqlLite(staSQLquery, chessTournament);
					insertDataIntoTablePlayersSQLite(chessTournament, staSQLquery);
					SQLConnection.closeStatement(staSQLquery);
					SQLConnection.closeConnection(cnDB);
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
	
	
	
	private void createTablePlayersSqlLite(Statement staSQLquery, ArrayList<ChessPlayer> chessTournament) {
		SQLConnection.dropTable(staSQLquery, "players");
		String stSQLCreate = "CREATE TABLE Players ("
                + "id VARCHAR(9) NOT NULL, "
                + "name VARCHAR(100), "
                + "country VARCHAR(100), "
                + "score1 REAL, "
                + "score2 REAL, "
                + "score3 REAL, "
                + "totalScore REAL, "
                + " PRIMARY KEY (ID))";
		SQLConnection.createTable(staSQLquery, "players", stSQLCreate);
	}
	
	private void insertDataIntoTablePlayersSQLite(ArrayList<ChessPlayer> chessTournament, Statement staSQLquery) {	
		String fields = "(id, name, country, score1, score2, score3, totalScore)";
		try {
			for(ChessPlayer p : chessTournament) {
				SQLConnection.insertDataIntoTable(staSQLquery, "players", fields, p.toString());
			}
			System.out.println("Players succesfully inserted.");
		} catch (SQLException e) {
			System.out.println("Player insert error.");
		}
	}
	
	public static void listPlayersFromSQLite() throws SQLException {
		Connection cnDB = SQLConnection.getConnectionSqlLite(URL);
		Statement staSQLquery = SQLConnection.getStatementSqlLite(cnDB);
		
		ResultSet rsPlayersList = SQLConnection.getAllTableData(staSQLquery, "players");
		while(rsPlayersList.next()) {
			System.out.println("");
			System.out.println("ID: " + rsPlayersList.getString("ID"));
			System.out.println("Name: " + rsPlayersList.getString("name"));
			System.out.println("Country: " + rsPlayersList.getString("country"));
			System.out.println("Score 1: " + rsPlayersList.getFloat("score1"));
			System.out.println("Score 2: " + rsPlayersList.getFloat("score2"));
			System.out.println("Score 3: " + rsPlayersList.getFloat("score3"));
			System.out.println("Total Score: " + rsPlayersList.getFloat("totalScore"));
			System.out.println("");
		}
		SQLConnection.closeStatement(staSQLquery);
		SQLConnection.closeConnection(cnDB);
	}
	
	public static void deleteAllPlayers() {
		Connection cnDB = SQLConnection.getConnectionSqlLite(URL);
		Statement staSQLquery = SQLConnection.getStatementSqlLite(cnDB);
		
		SQLConnection.deleteDataFromTable(staSQLquery, "players");
		
		SQLConnection.closeStatement(staSQLquery);
		SQLConnection.closeConnection(cnDB);
	}
	
	public static void copyDataFromSQLiteToMongo() {
		try {
			ArrayList<ChessPlayer> arPlayersList = getDataFromPlayersTableSQLite();
			createPlayersCollection();
			insertInfoIntoPlayersCollectionMongo(arPlayersList);			
		} catch (SQLException e) {
			System.out.println("Data reading failed.");
		} catch (Exception e) {
			System.out.println("Somthing was wrong with mongo.");
		}
	}
	
	private static ArrayList getDataFromPlayersTableSQLite() throws SQLException {
		ArrayList<ChessPlayer> arPlayersList = new ArrayList<ChessPlayer>();
		
		Connection cnDB = SQLConnection.getConnectionSqlLite(URL);
		Statement staSQLquery = SQLConnection.getStatementSqlLite(cnDB);
		
		ResultSet rsPlayersList = SQLConnection.getAllTableData(staSQLquery, "players");
		while(rsPlayersList.next()) {
			arPlayersList.add(new ChessPlayer(rsPlayersList.getString("ID"), rsPlayersList.getString("name"), rsPlayersList.getString("country"), rsPlayersList.getFloat("score1"), rsPlayersList.getFloat("score2"), rsPlayersList.getFloat("score3")));
		}
		SQLConnection.closeStatement(staSQLquery);
		SQLConnection.closeConnection(cnDB);
		return arPlayersList;
	}
	
	private static void createPlayersCollection() {
		MongoClient cnMongoDB = DBMongoDB.connectToDB();
		try {
			MongoDatabase chessTournament = cnMongoDB.getDatabase("ChessTournament");
			DBMongoDB.clearCollection(chessTournament, "players");
			DBMongoDB.createCollectionIfNotExists(chessTournament, "players");			
		} catch (Exception e) {
			System.out.println("Gettting Database failed.");
		}
		DBMongoDB.closeDB(cnMongoDB);
	}
	
	private static void insertInfoIntoPlayersCollectionMongo(ArrayList<ChessPlayer> arPlayersList) {
		MongoClient cnMongoDB = DBMongoDB.connectToDB();
		try {
			MongoDatabase chessTournament = cnMongoDB.getDatabase("ChessTournament");
			
			Document docPlayer;
			for(ChessPlayer cp : arPlayersList) {
				String ID = cp.getId();
				String name = cp.getFullname();
				String country = cp.getCountry();
				Float score1 = cp.getScore1();
				Float score2 = cp.getScore2();
				Float score3 = cp.getScore3();
				Float totalScore = cp.getTotalScore();
				docPlayer = new Document("_id", ID);
				docPlayer.append("name", name);
				docPlayer.append("country", country);
				docPlayer.append("score1", score1);
				docPlayer.append("score2", score2);
				docPlayer.append("score3", score3);
				docPlayer.append("totalScore", totalScore);
				chessTournament.getCollection("players").insertOne(docPlayer);
			}
		} catch (Exception e) {
			System.out.println("Collection populating failed.");
		}
		DBMongoDB.closeDB(cnMongoDB);
	}
	
	public static void readPlayersDataFromMongo() {
		MongoClient cnMongoDB = DBMongoDB.connectToDB();
		try {
			MongoDatabase chessTournament = cnMongoDB.getDatabase("ChessTournament");
			MongoCollection<Document> mcolPlayers = chessTournament.getCollection("players");
			MongoCursor<Document> mcuPlayer = mcolPlayers.find().iterator();
			
			int iNumPlayers = 0;
			while(mcuPlayer.hasNext()) {
				iNumPlayers++;
				Document docPlayer = mcuPlayer.next();
				System.out.println("");
				System.out.println("ID: " + docPlayer.getString("_id"));
				System.out.println("Name: " + docPlayer.getString("name"));
				System.out.println("Country: " + docPlayer.getString("country"));
				System.out.println("Score 1: " + docPlayer.getDouble("score1"));
				System.out.println("Score 2: " + docPlayer.getDouble("score2"));
				System.out.println("Score 3: " + docPlayer.getDouble("score3"));
				System.out.println("Total Score: " + docPlayer.getDouble("totalScore"));
			}
			if(iNumPlayers == 0) {
				System.out.println("No players found.");
			}
		} catch (Exception e) {
			System.out.println("Something was wrong.");
		}
	}
}
