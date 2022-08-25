package com.godoro.relation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AggregateList {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost/dbgodoro";
        String username = "postgres";
        String password = "1234";
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select e.departmentid , departmentname ,sum(monthlysalary) as salarySum \r\n"
                    +"from employee e \r\n"
                    +"right join department d on e.departmentid = d.departmentid\r\n" 	
                    +"group by e.departmentid , d.departmentname ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            double salarySum = resultSet.getDouble("salarySum");
            long departmentid = resultSet.getLong("departmentid");
            String departmentname = resultSet.getString("departmentname");
            System.out.println(departmentid+ " " + departmentname+ " "+ salarySum );
        }
        connection.close();
    }
}
