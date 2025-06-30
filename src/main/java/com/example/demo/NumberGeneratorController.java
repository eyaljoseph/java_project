package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class NumberGeneratorController {

    private final NumberGenerator numberGenerator = new NumberGenerator();

    @GetMapping("/generate_number")
    public int generateNumber() {
        int randomNumber = numberGenerator.generateRandomNumber();
        System.out.println("Generated number: " + randomNumber);
        return randomNumber;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
    
    @GetMapping("/get_avg")
    public int getAvg() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int randomNumber = numberGenerator.generateRandomNumber();
            sum += randomNumber;
        }
        return sum / 10;
    }

    @GetMapping("/mongo_example")
    public List<String> mongoExample() {
        MongoExample mongoExample = new MongoExample();
        return mongoExample.insertAndListUsers();
    }
}
