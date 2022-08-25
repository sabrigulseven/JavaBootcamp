package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionTest {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:postgresql://localhost/dbgodoro";
        String username = "postgres";
        String password = "1234";
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "insert into Product(productName, salesPrice) values (?,?)";

        connection.setAutoCommit(false);

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "Ürün 101");
        statement.setDouble(2, 3010);
        statement.executeUpdate();

        PreparedStatement statement2 = connection.prepareStatement(sql);
        statement2.setString(1, "Ürün 101");
        statement2.setDouble(2, 3010);
        statement2.executeUpdate();

        PreparedStatement statement3 = connection.prepareStatement("X"+sql+"X"); //wrong on purpose
        statement3.setString(1, "Ürün 101");
        statement3.setDouble(2, 3010);
        statement3.executeUpdate();

        connection.commit();
        connection.close();
    }
}
