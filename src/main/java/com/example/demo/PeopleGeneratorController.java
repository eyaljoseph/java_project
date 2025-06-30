package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PeopleGeneratorController {

    private final PeopleGenerator peopleGenerator = new PeopleGenerator();

    @GetMapping("/generate_number")
    public int generateNumber() {
        int randomNumber = peopleGenerator.generateRandomNumber();
        System.out.println("Generated number: " + randomNumber);
        return randomNumber;
    }

    @GetMapping("/generate_name")
    public String generateName() {
        String randomName = peopleGenerator.generateRandomName();
        System.out.println("Generated name: " + randomName);
        return randomName;
    }

    @GetMapping("/generate_person")
    public List<String> mongoExample() {
        PeopleGenerator.Person randomPerson = peopleGenerator.generateRandomPerson();
        MongoExample mongoExample = new MongoExample();
        return mongoExample.insertAndListUsers(randomPerson);
    }

    @GetMapping("/avgerage_age")
    public String averageAge() {
        MongoExample mongoExample = new MongoExample();
        int averageAge = mongoExample.averageAge();
        System.out.println("Average age: " + averageAge);
        return "Average age: " + averageAge;
    }
}
