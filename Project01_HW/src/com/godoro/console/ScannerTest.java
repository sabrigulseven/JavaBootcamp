package com.godoro.console;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        System.out.println("setAccountId: ");
        account.setAccountId(scanner.nextLong());

        System.out.println("setAccountName: ");
        account.setAccountName(scanner.next());

        System.out.println("setAmountLocal: ");
        account.setAmountLocal(scanner.nextDouble());

        System.out.printf("Uzun: %5d Sicim: %10s İkişer:  %11.2f\n", account.getAccountId(),account.getAccountName(),account.getAmountLocal());
        scanner.close();
    }
    
}
