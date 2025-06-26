package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberGeneratorController {

    private final NumberGenerator numberGenerator = new NumberGenerator();

    @GetMapping("/generate_number")
    public int generateNumber() {
        int randomNumber = numberGenerator.generateRandomNumber();
        System.out.println("Generated number: " + randomNumber);
        return randomNumber;
    }
}