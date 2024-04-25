package org.dmitriy.prack15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Prack15Application {

    public static void main(String[] args) {

        SpringApplication.run(Prack15Application.class, args);
    }

}
