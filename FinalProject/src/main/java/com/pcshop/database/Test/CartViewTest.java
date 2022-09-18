package com.pcshop.database.Test;

import java.util.List;

import com.pcshop.database.entity.CartProduct;
import com.pcshop.database.manager.CartManager;

public class CartViewTest {

	public static void main(String[] args) {
		CartManager cartManager = new CartManager();
		try {
			List<CartProduct> cartList = cartManager.viewCartProduct(5);
			for (CartProduct cartProduct : cartList) {
				System.out.println(cartProduct.getCartProductId()+" "
						+ cartProduct.getSalesQuantity()+" "
								+ cartProduct.getProductId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
