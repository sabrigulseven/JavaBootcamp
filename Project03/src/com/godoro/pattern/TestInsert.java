package com.godoro.pattern;

public class TestInsert {
    public static void main(String[] args) {
        try {
            ProductManager productManager = new ProductManager();
            Product product = new Product(0, "Buzdolabı", 1231);
            boolean isInserted= productManager.insert(product);
            if (isInserted)
                System.out.println("Eklendi.");
            else
                System.out.println("Eklenemedi.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
