package com.godoro.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public boolean insert(Product product) throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "insert into Product(productName, salesPrice) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());
        int affected = statement.executeUpdate();

        connection.close();
        return affected > 0;
    }

    public boolean update(Product product) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "update product set productName=?, salesprice=? where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(3, product.getProductId());
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }

    public boolean delete(long productId) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "delete from Product where productId =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productId);
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }

    public List<Product> list() throws Exception {
        List<Product> productList = new ArrayList<>();

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from product";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Product product = parse(resultSet);
            productList.add(product);
        }
        connection.close();

        return productList;
    }

    public List<Product> listBySalePriceGreater(double salespriceMin) throws Exception {
        List<Product> productList = new ArrayList<>();

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from product where salesprice >= ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        statement.setDouble(1, salespriceMin);
        while (resultSet.next()) {
            Product product = parse(resultSet);
            productList.add(product);
        }
        connection.close();

        return productList;
    }

    public Product find(long productId) throws Exception {
        Product product = null;

        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from product where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String productName = resultSet.getString("productName");
            double salesPrice = resultSet.getDouble("salesPrice");
            product = new Product(productId, productName, salesPrice);

        }
        connection.close();
        return product;
    }

    private Product parse(ResultSet resultSet) throws Exception{
        long productId = resultSet.getLong("productid");
        String productName = resultSet.getString("productName");
        double salesPrice = resultSet.getDouble("salesPrice");
        Product product = new Product(productId, productName, salesPrice);
        return product;
    }

    private List<Product> parseList(ResultSet resultSet) throws Exception {
        List<Product> productList = new ArrayList<>();
        while (resultSet.next()) {
            Product product = parse(resultSet);
            productList.add(product);
        }
        return productList;
    }
}
