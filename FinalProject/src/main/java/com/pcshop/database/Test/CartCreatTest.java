package com.pcshop.database.Test;

import java.sql.SQLException;

import com.pcshop.database.entity.Cart;
import com.pcshop.database.manager.CartManager;

public class CartCreatTest {
	public static void main(String[] args) {
		CartManager cartManager = new CartManager();
		try {
			Cart cart = cartManager.create("user1");
			System.out.println(cart.getCartId()+" "+cart.getCustomerName()+" "+ cart.getTotalAmount());
			if(cartManager.addCartProduct(cart.getCartId(), 11))
				System.out.println("cartproduct inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
