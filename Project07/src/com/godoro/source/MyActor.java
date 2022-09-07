package com.godoro.source;

public class MyActor {
    public String transform(int yourInt, String yourString, double yourDouble) {
        return Integer.toString(yourInt)+" - " +yourString+" - " +Double.toString(yourDouble);
    }

    public void consume(int yourInt, String yourString, double yourDouble) {
        System.out.println(Integer.toString(yourInt)+" - " +yourString+" - " +Double.toString(yourDouble));
    }

    public String produce() {
        return "üretildi";
    }
    public void process() {
        System.out.println("Süreç");
    }
}
