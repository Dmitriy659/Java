package com.example.pr10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@SpringBootApplication
public class Pr10Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        Lighter lighter = (Lighter) context.getBean(name);

        lighter.doLight();
    }

}
