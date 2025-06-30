package com.example.demo;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class MongoExample {

    private final PeopleGenerator peopleGenerator = new PeopleGenerator();

    public List<String> insertAndListUsers(PeopleGenerator.Person person) {
        List<String> results = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("testdb");
            MongoCollection<Document> collection = database.getCollection("users");

            // Insert a document
            Document doc = new Document("name", person.getName()).append("age", person.getAge());
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

    public int averageAge() {
        int totalAge = 0;
        int count = 0;
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("testdb");
            MongoCollection<Document> collection = database.getCollection("users");

            for (Document doc : collection.find()) {
                totalAge += doc.getInteger("age", 0);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count > 0 ? totalAge / count : 0;
    }
}