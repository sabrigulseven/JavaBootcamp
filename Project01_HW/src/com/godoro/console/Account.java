package com.godoro.console;

public class Account {

    private long accountId;
    private String accountName;
    private double amountLocal;
    
    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public double getAmountLocal() {
        return amountLocal;
    }
    public void setAmountLocal(double amountLocal) {
        this.amountLocal = amountLocal;
    }
    public Account(long accountId, String accountName, double amountLocal) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.amountLocal = amountLocal;
    }
    public Account() {
    }
    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", accountName=" + accountName + ", amountLocal=" + amountLocal
                + "]";
    }

    
    
}
