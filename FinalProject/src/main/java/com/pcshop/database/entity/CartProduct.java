package com.pcshop.database.entity;

public class CartProduct {
	private long cartProductId;
	private long cartId;
	private long productId;
	private int salesQuantity;
	private double salesPrice;

	public long getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public int getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(int salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public CartProduct(long cartProductId, long cartId, long productId, int salesQuantity, double salesPrice) {
		this.cartProductId = cartProductId;
		this.cartId = cartId;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
		this.productId = productId;
	}

	public CartProduct() {
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

}
