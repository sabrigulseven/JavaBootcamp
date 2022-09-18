package com.pcshop.database.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pcshop.database.entity.Cart;
import com.pcshop.database.entity.CartProduct;
import com.pcshop.database.entity.Product;

public class CartManager {
	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String username = "postgres";
	private String password = "1234";
	private String driver = "org.postgresql.Driver";

	public CartManager() {
		try {
			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cart create(String customerName) throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);

		String sql = "insert into cart(customerName, totalamount) values (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, customerName);
		statement.setDouble(2, 0);
		Cart cart = new Cart();
		cart.setCustomerName(customerName);
		cart.setTotalAmount(0);
		int affected = statement.executeUpdate();
		if (affected == 0) {
			throw new SQLException("Creating failed");
		}
		try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
			if (generatedKeys.next()) {
				cart.setCartId(generatedKeys.getLong(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
		return cart;
	}

	public boolean addCartProduct(long cartid, long productid) throws Exception {
		ProductManager productManager = new ProductManager();
		Product product = productManager.find(productid);
		Connection connection = DriverManager.getConnection(url, username, password);
		String sql = "insert into cartproduct(cartid, productid, salesQuantity,salesprice) values (?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, cartid);
		statement.setLong(2, productid);
		statement.setInt(3, 1);
		statement.setDouble(4, product.getSalesPrice());
		int affected = statement.executeUpdate();
		connection.close();

		return affected > 0;

	}

	public boolean deleteCartProduct(long cartId, long productId) throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		String sql = "delete from Cart where productId =?, cartID =?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, productId);
		statement.setLong(2, cartId);
		int affected = statement.executeUpdate();
		connection.close();
		return affected > 0;
	}

	public List<CartProduct> viewCartProduct(long cartId) throws Exception {
		Connection connection = DriverManager.getConnection(url, username, password);
		String sql = "select * from CartProduct where cartID =?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, cartId);
		ResultSet resultSet = statement.executeQuery();
		List<CartProduct> cartProductList = parseList(resultSet);

		connection.close();

		return cartProductList;
	}

	private List<CartProduct> parseList(ResultSet resultSet) throws Exception {
		List<CartProduct> cartProductList = new ArrayList<>();
		while (resultSet.next()) {
			CartProduct product = parse(resultSet);
			cartProductList.add(product);
		}
		return cartProductList;
	}

	private CartProduct parse(ResultSet resultSet) throws Exception {
		long cartProductId = resultSet.getLong("cartProductId");
		long cartId = resultSet.getLong("cartId");
		long productId = resultSet.getLong("productId");
		int salesQuantity = resultSet.getInt("salesQuantity");
		double salesPrice = resultSet.getDouble("salesPrice");
		CartProduct product = new CartProduct(cartProductId, cartId, productId, salesQuantity, salesPrice);
		return product;
	}
}
