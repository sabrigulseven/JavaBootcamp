package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestUpdate {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:postgresql://localhost/dbgodoro";
        String username = "postgres";
        String password = "1234";
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "update product set productName=?, salesprice=? where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(3, 3);
        statement.setString(1, "Tablet");
        statement.setDouble(2, 1332);
        statement.executeUpdate();
        connection.close();
    }
}
