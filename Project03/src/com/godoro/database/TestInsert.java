package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsert {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost/dbgodoro";
        String username = "postgres";
        String password = "1234";   
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,username,password);
        
        String sql = "insert into Product(productName, salesPrice) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql); 
        statement.setString(1, "Cep Telefonu");
        statement.setDouble(2, 5465);
        statement.executeUpdate();
        connection.close();
    }
}
