package com.godoro.console;

public class AccountConventerTest {
    public static void main(String[] args) {
        
        String line = "601;Kasa Hesabı;23560";
        Account account = AccountConventer.parse(line);
        System.out.println(account.toString());
        String string = AccountConventer.format(account);
        System.out.println(string);

    }
}
