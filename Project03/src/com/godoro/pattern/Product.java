package com.godoro.pattern;

public class Product {

	private long productId;
	private String productName;
	private double salesPrice;
	
	public Product() {
	}

	public Product(long productId, String productName, double salesPrice) {
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
	}

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
		if(salesPrice < 0)
			throw new IllegalArgumentException("Fiyat negatif olamaz " );
		this.salesPrice = salesPrice;
	}
	
	
}
