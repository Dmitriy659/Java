package com.example.pr10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Lamp lamp() {
        return new Lamp();
    }

    @Bean
    public FlashLighter flashlight() {
        return new FlashLighter();
    }

    @Bean
    public Firefly firefly() {
        return new Firefly();
    }
}
