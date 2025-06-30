package com.example.demo;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class MongoExample {
    public List<String> insertAndListUsers() {
        List<String> results = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("testdb");
            MongoCollection<Document> collection = database.getCollection("users");

            // Insert a document
            Document doc = new Document("name", "Jojo").append("age", 20);
            collection.insertOne(doc);

            // Collect all documents as JSON strings
            for (Document d : collection.find()) {
                results.add(d.toJson());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            results.add("Error: " + e.getMessage());
        }
        return results;
    }
}