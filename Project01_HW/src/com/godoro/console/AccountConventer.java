package com.godoro.console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AccountConventer {

    public static Account parse(String line) {
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
        return account;
    }
    
    public static String format(Account account) {
        StringBuilder builder = new StringBuilder();
        builder.append(account.getAccountId()).append(";");
        builder.append(account.getAccountName()).append(";");
        builder.append(account.getAmountLocal());
        return builder.toString();
    }
}
