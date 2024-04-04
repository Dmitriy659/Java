package com.example.pr13;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pr13Application {
    @Value("${student.name}")
    private String name;
    @Value("${student.last_name}")
    private String last_name;
    @Value("${student.group}")
    private String group;

    public static void main(String[] args) {
        SpringApplication.run(Pr13Application.class, args);
    }

    @PostConstruct
    void doInit() {
        System.out.println(name + ", " + last_name + ", " + group);
    }
}
