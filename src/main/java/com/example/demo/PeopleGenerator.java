package com.example.demo;

import com.github.javafaker.Faker;

public class PeopleGenerator {

    private final Faker faker = new Faker();

    public int generateRandomNumber() {
        return (int) (Math.random() * 100);
    }

    public String generateRandomName() {
        return faker.name().fullName();
    }

    // Person class as an inner class
    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
    }

    // Constructor method to generate a random person
    public Person generateRandomPerson() {
        String name = generateRandomName();
        int age = 18 + faker.random().nextInt(63); // age between 18 and 80
        return new Person(name, age);
    }
}
