package com.assessableactivity.U2JDBCActivity;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLConnection {
	public static Connection getConnectionSqlLite(String URL) {
		try {
			Connection cnDB = DriverManager.getConnection(URL);
			return cnDB;
		} catch (SQLException e) {
			System.out.println("Connection refused.");
		}
		return null;
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Connection closing failed.");
		}
	}
	
	public static void closeStatement(Statement stmt) {
		try {
			stmt.close();
			System.out.println("Statement succesfully closed.");
		} catch (SQLException e) {
			System.out.println("Statement closeing failed.");
		}
	}
	
	public static Statement getStatementSqlLite(Connection cnDB) {
		Statement staSQLquery = null;
		try {
			staSQLquery = cnDB.createStatement();
		} catch (SQLException e) {
			System.out.println("Statement creation failed.");
		}
		return staSQLquery;
	}
	
	public static void dropTable(Statement staSQLquery, String table) {
		String stSQLDropTable = "DROP TABLE IF EXISTS " + table;
		try {
			staSQLquery.executeQuery(stSQLDropTable);			
			System.out.println("Table " + table + " succesfully deleted.");
		} catch (SQLException e) {
			System.out.println("Table drop failed.");
		}
	}
	
	public static void createTable(Statement staSQLquery, String table, String stSQLCreate) {
		try {
			staSQLquery.executeUpdate(stSQLCreate);
			System.out.println("Table succesfully created.");		
		} catch (SQLException e) {
			System.out.println("Table creation failed.");
		}
	}
	
	public static void insertDataIntoTable(Statement staSQLquery, String table, String fields, String values) throws SQLException {
		String stSQLInsertPlayers = "INSERT INTO " + table + " " + fields + " VALUES " + values + ";";
		staSQLquery.executeUpdate(stSQLInsertPlayers);
	}
	
	public static ResultSet getAllTableData(Statement staSQLquery, String table) {
		String stSQLSelect = "Select * from " + table;
		try {
			ResultSet playersList = staSQLquery.executeQuery(stSQLSelect);
			return playersList;
		} catch (SQLException e) {
			System.out.println("Something was wrong reading the table.");
		}
		return null;
	}
	
	public static void deleteDataFromTable(Statement staSQLquery, String table) {
		String stDelete = "DELETE FROM " + table;
		try {
			staSQLquery.executeUpdate(stDelete);
			System.out.println("Data succesfully deleted from table" + table);
		} catch (Exception e) {
			System.out.println("Data delete failed.");
			e.printStackTrace();
		}
	}
}
