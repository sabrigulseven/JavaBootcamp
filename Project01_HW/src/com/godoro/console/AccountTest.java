package com.godoro.console;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AccountTest {
    public static void main(String[] args) {
        String line="601;Kasa Hesabı;23560";
        StringTokenizer stringTokenizer = new StringTokenizer(line, ";");
        List<String> tokens = new ArrayList<String>();
        while(stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            tokens.add(token);
        }

        Account account = new Account();
        account.setAccountId(Long.parseLong(tokens.get(0)));
        account.setAccountName(tokens.get(1));
        account.setAmountLocal(Double.parseDouble(tokens.get(2)));

        System.out.println(account.toString());

        StringBuilder builder = new StringBuilder();
        builder.append(account.getAccountId()).append(";");
        builder.append(account.getAccountName()).append(";");
        builder.append(account.getAmountLocal());
        String string = builder.toString();
        System.out.println(string);
    }
}
