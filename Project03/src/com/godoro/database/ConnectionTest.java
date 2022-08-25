package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
    public static void main(String[] args) throws Exception {
    	
        String url = "jdbc:postgresql://localhost/dbgodoro";
        String username = "postgres";
        String password = "1234";
        
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        //Class.forName(driver).newInstance();
        Connection connection = DriverManager.getConnection(url,username,password);
        
        System.out.println(connection.getMetaData().getDatabaseProductName()); 
        connection.close();
    }
}
