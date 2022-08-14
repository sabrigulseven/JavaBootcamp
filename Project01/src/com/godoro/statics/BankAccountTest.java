package com.godoro.statics;

public class BankAccountTest {
    
    public static void main(String[] args) {
        
        BankAccount.setRate(24);

        BankAccount account1  = new BankAccount(3000);
        BankAccount.setRate(36);
        System.out.println("Tutar I  9Aylık: " + account1.getAmount(9));
        System.out.println("Tutar II Yıllık: " + account1.getAmount(BankAccount.MONTHS_IN_A_YEAR));
    }
}
