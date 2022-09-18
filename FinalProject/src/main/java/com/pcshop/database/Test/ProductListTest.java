package com.pcshop.database.Test;

import java.util.List;

import com.pcshop.database.entity.Product;
import com.pcshop.database.manager.ProductManager;

public class ProductListTest {
    public static void main(String[] args) throws Exception {
        ProductManager productManager = new ProductManager();
        List<Product> products = productManager.list();
        for (Product product : products) {
            System.out.println(product.getProductId() + " "
                    + product.getProductName() + " "
                    + product.getSalesPrice() + " "
                    + product.getCategory().getCategoryName());
        }
        products.clear();
        System.out.println("---------------------------------------");
        products = productManager.listByCategory(1);
        for (Product product : products) {
            System.out.println(product.getProductId() + " "
                    + product.getProductName() + " "
                    + product.getSalesPrice() + " "
                    + product.getCategory().getCategoryName());
        }

    }
}
