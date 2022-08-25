package com.godoro.pattern;

public class TestDelete {
    public static void main(String[] args) {
        try {
            ProductManager productManager = new ProductManager();
            Product product = new Product(7, "Fırın", 3221);
            boolean isUpdated= productManager.delete(product.getProductId());
            if (isUpdated)
                System.out.println("Silindi.");
            else
                System.out.println("Silinmedi.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
