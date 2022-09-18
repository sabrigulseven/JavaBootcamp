package com.pcshop.database.Test;

import com.pcshop.database.entity.Product;
import com.pcshop.database.manager.ProductManager;

public class ProductFindTest {
    public static void main(String[] args) throws Exception {
        ProductManager productManager = new ProductManager();
        Product product = productManager.find(2);
        System.out.println(product.getProductName() + " "
                + product.getSalesPrice() + " "
                + product.getCategory().getCategoryName());
    }
}
