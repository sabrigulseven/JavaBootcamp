package com.godoro.pattern;

public class TestInsert {
    public static void main(String[] args) {
        try {
            CustomerManager customerManager = new CustomerManager();
            Customer customer = new Customer(1, "Zeki Müren", 5662);
            boolean isInserted= customerManager.insert(customer);
            if (isInserted)
                System.out.println("Eklendi.");
            else
                System.out.println("Eklenemedi.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
