package com.godoro.inheritance;

abstract public class Person {
    
    protected String firstName;
    protected String lastName;
    protected String emailAdres;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
        
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    abstract public String getGreeting();
    
    public String getEmailAdres() {
        return emailAdres;
    }
    public void setEmailAdres(String emailAdres) {
        this.emailAdres = emailAdres;
    }
}
