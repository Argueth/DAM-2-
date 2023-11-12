package com.assessableactivity.U2JDBCActivity;

import java.sql.SQLException;

/*
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ChessTournament chessT = new ChessTournament();
		int option = -1;
		while(option != 0) {
			showMenu();
			//Try block where I collect all exceptions from the entire application to centralize their control.
			try {
				option = IOTools.AskInt("Select and option", 0, 5);
				switch (option) {
				case 1:
					chessT.addPlayers();
					break;
				case 2:
					ChessTournament.listPlayersFromSQLite();
					break;
				case 3:
					ChessTournament.deleteAllPlayers();
					break;
				case 4:;
					ChessTournament.copyDataFromSQLiteToMongo();
					break;
				case 5:
					ChessTournament.readPlayersDataFromMongo();
					break;
				case 0:
					break;
				}
			} catch (SQLException e) {
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
    
    public static void showMenu() {
		System.out.println("""
				*****
				MENU
				*****
				=========================================================
				 1. Get chess players and scores (to SQLite)
				 2. List all chess players
				 3. Delete all chess players (from SQLite)
				 4. Dump data from SQLite to MongoDB
				 5. List all chess players (from MongoDB)
				 
				 0. Exit
				=========================================================
				""");
	}
}
