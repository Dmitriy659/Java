package com.example.pr10;

public class Lamp implements Lighter {
    @Override
    public void doLight() {
        System.out.println("Lamp is lighting");
    }
}
