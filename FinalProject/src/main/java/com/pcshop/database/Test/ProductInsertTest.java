package com.pcshop.database.Test;

import com.pcshop.database.entity.Category;
import com.pcshop.database.entity.Product;
import com.pcshop.database.manager.CategoryManager;
import com.pcshop.database.manager.ProductManager;

public class ProductInsertTest {
    public static void main(String[] args) throws Exception {
        ProductManager productManager = new ProductManager();
        CategoryManager categoryManager = new CategoryManager();
        Category category = categoryManager.find(1);
        Product product = new Product(0, "test", 1111, category);
        boolean isInserted = productManager.insert(product);
        if (isInserted)
            System.out.println("Eklendi.");
        else
            System.out.println("Eklenemedi.");
    }
}
