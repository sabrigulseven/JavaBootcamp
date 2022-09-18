package com.pcshop.database.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pcshop.database.entity.Category;

public class CategoryManager {
    private String url = "jdbc:postgresql://localhost/dbgodoro";
    private String username = "postgres";
    private String password = "1234";
    private String driver = "org.postgresql.Driver";

    public CategoryManager() {
        try {
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Category find(long categoryId) throws Exception {
        Category category = null;

        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from category where categoryId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, categoryId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            category = parse(resultSet);
        }
        connection.close();
        return category;
    }
    public Category find(String categoryName) throws Exception {
        Category category = null;

        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from category where categoryName=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, categoryName);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            category = parse(resultSet);
        }
        connection.close();
        return category;
    }
    private Category parse(ResultSet resultSet) throws Exception {
        long categoryId = resultSet.getLong("categoryid");
        String categoryName = resultSet.getString("categoryName");
        Category category = new Category(categoryId, categoryName);
        return category;
    }

    public List<Category> list() throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from category";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Category> categoryList = parseList(resultSet);

        connection.close();

        return categoryList;
    }

    private List<Category> parseList(ResultSet resultSet) throws Exception {
        List<Category> categoryList = new ArrayList<>();
        while (resultSet.next()) {
            Category category = parse(resultSet);
            categoryList.add(category);
        }
        return categoryList;
    }

    public boolean insert(Category category) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "insert into Category(categoryName) values (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, category.getCategoryName());

        int affected = statement.executeUpdate();

        connection.close();
        return affected > 0;
    }

    public boolean update(Category category) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "update category set categoryName=? where categoryId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(2, category.getCategoryId());
        statement.setString(1, category.getCategoryName());

        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }

    public boolean delete(long categoryId) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "delete from Category where categoryId =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, categoryId);
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }
}
