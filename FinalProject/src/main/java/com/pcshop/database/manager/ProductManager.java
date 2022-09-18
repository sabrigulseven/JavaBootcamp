package com.pcshop.database.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pcshop.database.entity.Category;
import com.pcshop.database.entity.Product;

public class ProductManager {
    private String url = "jdbc:postgresql://localhost/dbgodoro";
    private String username = "postgres";
    private String password = "1234";
    private String driver = "org.postgresql.Driver";

    public ProductManager() {
        try {
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product find(long productId) throws Exception {
        Product product = null;

        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from product where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            product = parse(resultSet);
        }
        connection.close();
        return product;
    }

    private Product parse(ResultSet resultSet) throws Exception {
        long productId = resultSet.getLong("productid");
        String productName = resultSet.getString("productName");
        double salesPrice = resultSet.getDouble("salesPrice");
        long categoryId = resultSet.getLong("categoryId");
        CategoryManager categoryManager = new CategoryManager();
        Category category = categoryManager.find(categoryId);
        Product product = new Product(productId, productName, salesPrice, category);
        return product;
    }

    public List<Product> list() throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from product";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Product> productList = parseList(resultSet);

        connection.close();

        return productList;
    }

    public List<Product> listByCategory(long categoryId) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from product where categoryid =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, categoryId);
        ResultSet resultSet = statement.executeQuery();
        List<Product> productList = parseList(resultSet);

        connection.close();

        return productList;
    }
    private List<Product> parseList(ResultSet resultSet) throws Exception {
        List<Product> productList = new ArrayList<>();
        while (resultSet.next()) {
            Product product = parse(resultSet);
            productList.add(product);
        }
        return productList;
    }

    public boolean insert(Product product) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "insert into Product(productName, salesPrice,categoryid) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());
        statement.setLong(3, product.getCategory().getCategoryId());

        int affected = statement.executeUpdate();

        connection.close();
        return affected > 0;
    }

    public boolean update(Product product) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "update product set productName=?, salesprice=?, categoryid=? where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(4, product.getProductId());
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());
        statement.setLong(3, product.getCategory().getCategoryId());
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }

    public boolean delete(long productId) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "delete from Product where productId =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productId);
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }
}
