package com.godoro.pattern;

public class TestUpdate {
    public static void main(String[] args) {
        try {
            ProductManager productManager = new ProductManager();
            Product product = new Product(7, "Fırın", 3221);
            boolean isUpdated= productManager.update(product);
            if (isUpdated)
                System.out.println("Güncellendi.");
            else
                System.out.println("Güncellenemedi.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
