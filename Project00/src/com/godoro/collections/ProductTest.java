package com.godoro.collections;


import com.godoro.inventory.Product;

public class ProductTest {
	public static void main(String[] args) {
		
		Product[] products = {
				new Product(501, "Cep Telefonu", 1300.0),
				new Product(502, "Ev Telefonu", 5300.0),
				new Product(503, "Bilgisayar", 800.0)
		};
		double priceSum = 0;
		for (Product product : products) {
			priceSum += product.getSalesPrice();
		}
		double priceAverage = priceSum / products.length;
		System.out.println("Eder ortalama: " + priceAverage);
	}
}
