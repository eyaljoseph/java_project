package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * App.java
 * 
 * ✅ Similar to a 'main' in C++ (entry point).
 * ✅ Similar to a 'app.py' in Python.
 * ✅ Starts the Spring Boot app and exposes a test REST route.
 */
@SpringBootApplication
@RestController
public class App {

    // Similar to 'main' in C++ or 'if __name__ == "__main__":' in Python
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // Simple test REST endpoint
    // Similar to '@app.route("/")' in Flask
    @GetMapping("/")
    public String hello() {
        return "👋 Hello from Spring Boot! (comparable to Python's Flask 'hello' route)";
    }
}
