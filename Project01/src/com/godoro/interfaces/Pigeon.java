package com.godoro.interfaces;

public class Pigeon extends Bird {

    public Pigeon(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Güvercin" + name + "uçuyor...");        
    }

    @Override
    public void land() {
        System.out.println("Güvercin" + name + "konuyor...");        
    }
    
}
