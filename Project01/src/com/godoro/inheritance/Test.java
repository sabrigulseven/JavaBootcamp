package com.godoro.inheritance;

public class Test {

    public static void main(String[] args) {

        Customer customer = new Customer(401,"Neşet","Ertaş",3450);
        customer.setEmailAdres("neset@godoro.com");

        Person person = new Customer(402,"Mahsuni","Şerif",6540);
        person.setEmailAdres("mahsuni@godoro.com");

        Supplier supplier = new Supplier(403, "Orhan", "Gencebay", 8215);
        supplier.setEmailAdres("orhan@godoro.com");

        System.out.println(customer.getGreeting() + " " + customer.getFullName());
        System.out.println(person.getGreeting() + " " + person.getFullName());
        System.out.println(supplier.getGreeting() + " " + supplier.getFullName());

        sendMail(customer);
        sendMail(person);
        sendMail(supplier);
    }
    private static void sendMail(Person person) {
        System.out.println();
        System.out.println("Kime: " + person.getEmailAdres());
        System.out.println("Konu: " + person.getFullName());
        System.out.println("Gövde: " + person.getGreeting());
    }
}
