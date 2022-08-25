package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestAverage {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost/dbgodoro";
        String username = "postgres";
        String password = "1234";
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select avg(salesprice) as averagePrice from PRODUCT";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            double averagePrice = resultSet.getDouble("averagePrice");
            System.out.println("ortalama: " + averagePrice);
        }
        connection.close();
    }
}
