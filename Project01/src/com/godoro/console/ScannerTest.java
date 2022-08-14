package com.godoro.console;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Uzun: ");
        long l = scanner.nextLong();

        System.out.println("Sicim: ");
        String s = scanner.nextLine();

        System.out.println("İkişer: ");
        double d = scanner.nextDouble();

        System.out.printf("Uzun: %5d Sicim: %10s İkişer:  %11.2f\n", l,s,d);

        scanner.close();
    }
}
