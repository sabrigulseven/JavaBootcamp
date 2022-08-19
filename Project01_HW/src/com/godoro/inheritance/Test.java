package com.godoro.inheritance;

public class Test {
    public static void main(String[] args) {

        Employee employee = new Employee(201, "Erkan", "Ocaklı", 5470);
        employee.setEmailAdres("erkan@godoro.com");
        sendMail(employee);
        
    }
    private static void sendMail(Person person) {
        System.out.println();
        System.out.println("Kime: " + person.getEmailAdres());
        System.out.println("Konu: " + person.getGreeting());
        System.out.println("Gövde: " + person.getGreeting() + " " + person.getFullName());
    }
}
