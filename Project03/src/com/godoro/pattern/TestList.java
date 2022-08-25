package com.godoro.pattern;

import java.util.List;

public class TestList {
    public static void main(String[] args) throws Exception{
        ProductManager productManager = new ProductManager();
        List<Product> productList = productManager.list();
        for (Product product : productList) {
            System.out.println(product.getProductId() + " "
            +product.getProductName()+ " "
            +product.getSalesPrice());
        }
    }
}
