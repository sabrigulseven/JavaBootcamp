package com.godoro.composition.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseManager<E> {
    private String url = "jdbc:postgresql://localhost/dbgodoro";
    private String user = "postgres";
    private String password = "1234";
    private String driver = "org.postgresql.Driver";

    protected Connection connection;

    public BaseManager() {
        try {
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void connect() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    protected void disconnect() throws SQLException {
        connection.close();
    }

    protected List<E> parseList(ResultSet resultSet) throws Exception {
        List<E> entityList = new ArrayList<>();
        while (resultSet.next()) {
            E product = parse(resultSet);
            entityList.add(product);
        }
        return entityList;
    }
    abstract protected E parse(ResultSet resultSet) throws Exception;

}
