package com.godoro.inventory;

public class ProductTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setProductId(501);
		product.setProductName("Cep Telefonu");
		product.setSalesPrice(1300);
		System.out.println(product.getProductId() + " "
				+product.getProductName() + " "
				+product.getSalesPrice());
	}

}
