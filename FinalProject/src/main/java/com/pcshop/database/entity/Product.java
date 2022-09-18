package com.pcshop.database.entity;

public class Product {
    private long productId;
    private String productName;
    private double salesPrice;
    private Category category;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
    }

    public Product(long productId, String productName, double salesPrice, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.salesPrice = salesPrice;
        this.category = category;
    }

}
