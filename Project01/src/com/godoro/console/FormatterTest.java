package com.godoro.console;

import java.util.Formatter;

public class FormatterTest {
    public static void main(String[] args) {
        long l = 3;
        String s = "godoro";
        double d = 3.1415;
        System.out.printf("Uzun: %5d Sicim: %10s İkişer:  %11.2f\n", l,s,d);

        Formatter formatter = new Formatter(System.out);
        formatter.format("Uzun: %5d Sicim: %10s İkişer:  %11.2f\n", l,s,d);
        formatter.close();
    }
}
