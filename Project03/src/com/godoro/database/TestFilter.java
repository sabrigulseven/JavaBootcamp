package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestFilter {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:postgresql://localhost/dbgodoro";
        String username = "postgres";
        String password = "1234";
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from product where productname like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%ep Te%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            long productId = resultSet.getLong("productid");
            String productName = resultSet.getString("productName");
            double salesPrice = resultSet.getDouble("salesPrice");
            System.out.println(productId+ " " + productName + " " + salesPrice);
        }
        connection.close();
    }
}
