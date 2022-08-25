package com.godoro.relation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RelationList {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost/dbgodoro";
        String username = "postgres";
        String password = "1234";
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from employee e left join department d on e.departmentid=d.departmentid ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            long employeeid = resultSet.getLong("employeeid");
            String employeeName = resultSet.getString("employeename");
            double monthlySalary = resultSet.getDouble("monthlySalary");
            long departmentid = resultSet.getLong("departmentid");
            String departmentname = resultSet.getString("departmentname");
            System.out.println(employeeid+ " " + employeeName + " " + monthlySalary + " " + departmentid+ " " + departmentname+ " " );
        }
        connection.close();
    }
}
