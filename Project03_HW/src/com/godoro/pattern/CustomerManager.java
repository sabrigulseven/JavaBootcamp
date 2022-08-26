package com.godoro.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private String url = "jdbc:postgresql://localhost/dbgodoro";
    private String username = "postgres";
    private String password = "1234";
    private String driver = "org.postgresql.Driver";

    public CustomerManager() {
        try {
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insert(Customer customer) throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "insert into Customer(customerName, totalDebit) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customer.getCustomerName());
        statement.setDouble(2, customer.getTotalDebit());
        int affected = statement.executeUpdate();

        connection.close();
        return affected > 0;
    }

    public boolean update(Customer product) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "update Customer set CustomerName=?, TotalDebit=? where CustomerId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(3, product.getCustomerId());
        statement.setString(1, product.getCustomerName());
        statement.setDouble(2, product.getTotalDebit());
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }

    public boolean delete(long customerId) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "delete from CUSTOMER where customerId =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, customerId);
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }

    public List<Customer> list() throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from CUSTOMER";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Customer> customerList = parseList(resultSet);

        connection.close();

        return customerList;
    }

    public List<Customer> listByTotalDebitGreater(double totalDebitMin) throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from CUSTOMER where TotalDebit >= ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, totalDebitMin);
        ResultSet resultSet = statement.executeQuery();
        List<Customer> customerList = parseList(resultSet);

        connection.close();

        return customerList;
    }

    public Customer find(long customerId) throws Exception {
        Customer customer = null;

        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from CUSTOMER where customerId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, customerId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            customer = parse(resultSet);
        }
        connection.close();
        return customer;
    }

    private Customer parse(ResultSet resultSet) throws Exception {
        long customerId = resultSet.getLong("customerId");
        String customerName = resultSet.getString("customerName");
        double totalDebit = resultSet.getDouble("totalDebit");
        Customer customer = new Customer(customerId, customerName, totalDebit);
        return customer;
    }

    private List<Customer> parseList(ResultSet resultSet) throws Exception {
        List<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = parse(resultSet);
            customerList.add(customer);
        }
        return customerList;
    }
}
