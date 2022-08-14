package com.godoro.inheritance;

public class Customer extends Person{
    
    private long customerId;
    private double totalDebit;

    public long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public double getTotalDebit() {
        return totalDebit;
    }
    public void setTotalDebit(double totalDebit) {
        this.totalDebit = totalDebit;
    }
    public Customer(long customerId,String firstName, String lastName,  double totalDebit) {
        super(firstName, lastName);
        this.customerId = customerId;
        this.totalDebit = totalDebit;
    }
   public Customer() {

   }

   @Override
   public String getFullName() {
        return lastName + "," + firstName;
   }

   @Override
   public String getGreeting() {
        return "merhaba";
   }
}
