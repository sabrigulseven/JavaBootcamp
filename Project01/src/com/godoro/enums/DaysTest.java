package com.godoro.enums;

public class DaysTest {
    public static void main(String[] args) {
        
        Days days = Days.WEDNESDAY;
        printDay(days);
    }

    private static void printDay(Days days) {

        switch(days) {
            case MONDAY:
                System.out.println("Pazartesi");
                break;

            case TUESDAY:
                System.out.println("Salı");
                break;

            case WEDNESDAY:
                System.out.println("Çarşamba");
                break;
            }
            
    }
}
