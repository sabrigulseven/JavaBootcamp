package com.godoro.composition.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.godoro.composition.entity.Employee;

public class EmployeeManager extends BaseManager<Employee> {
    public Employee find(long productId) throws Exception {
        Employee employee = null;

        connect();
        String sql = "select * from EMPLOYEE where employeeId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            employee = parse(resultSet);
        }
        disconnect();
        return employee;
    }

    public List<Employee> list() throws Exception {

        connect();
        String sql = "select * from Employee";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Employee> productList = parseList(resultSet);

        disconnect();

        return productList;
    }

    protected Employee parse(ResultSet resultSet) throws Exception {
        long employeeid = resultSet.getLong("employeeid");
        String employeeName = resultSet.getString("employeeName");
        double monthlySalary = resultSet.getDouble("monthlySalary");
        Employee employee = new Employee(employeeid, employeeName, monthlySalary);
        return employee;
    }
}
