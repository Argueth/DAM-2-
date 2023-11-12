package com.assessableactivity.U2JDBCActivity;


import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class DBMongoDB {
	
	public static MongoClient connectToDB() {
		try {
			MongoClient mcMongoDB = MongoClients.create("mongodb://localhost:27017");
			System.out.println("Connection to database succesfylly completed.");
			return mcMongoDB;
		} catch (Exception e) {
			System.out.println("Database connection failed.");
		}
		return null;
	}
	
	public static void closeDB(MongoClient cnMongoDB) {
		try {
			cnMongoDB.close();
			System.out.println("Database succesfully closed.");
		} catch (Exception e) {
			System.out.println("Database closing failed.");
		}
	}
	
	public static boolean collectionExists(String stCollection, MongoDatabase database) {
		MongoIterable<String> mitCollection = database.listCollectionNames();
		for(String stIterCollection : mitCollection) {
			if(stIterCollection.equals(stCollection)) {
				return true;
			}
		}
		return false;
	}
	
	public static void createCollectionIfNotExists(MongoDatabase database, String stCollection) {
		try {
			if(!(collectionExists(stCollection, database))) {
				System.out.println("Collection does not exist.");
				database.createCollection(stCollection);
				System.out.println("Collection " + stCollection + " created in " + database + " database.");
			}
		} catch (Exception e) {
			System.out.println("Collection creation failed.");
			e.printStackTrace();
		}
	}
	
	public static void clearCollection(MongoDatabase database, String stCollection) {
		try {
			if(collectionExists(stCollection, database)) {
				System.out.println("Collection does exist.");
				MongoCollection<Document> mcCollection = database.getCollection(stCollection);
				mcCollection.deleteMany(new Document());
			}
		} catch (Exception e) {
			System.out.println("Collection creation failed.");
			e.printStackTrace();
		}
	}
}
