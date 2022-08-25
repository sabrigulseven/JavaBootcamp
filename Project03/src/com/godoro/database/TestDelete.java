package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestDelete {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost/dbgodoro";
        String username = "postgres";
        String password = "1234";   
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,username,password);
        
        String sql = "delete from Product where productId =?";
        PreparedStatement statement = connection.prepareStatement(sql); 
        statement.setLong(1, 3);
        statement.executeUpdate();
        connection.close();
    }
}
