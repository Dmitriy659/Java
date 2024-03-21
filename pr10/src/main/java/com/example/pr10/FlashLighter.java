package com.example.pr10;

public class FlashLighter implements Lighter{

    @Override
    public void doLight() {
        System.out.println("FlashLighter is lighting");
    }
}
