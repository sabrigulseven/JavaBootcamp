package com.godoro.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserManager {

	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String username = "postgres";
	private String password = "1234";
	private String driver = "org.postgresql.Driver";

	public UserManager() {
		try {
			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean create(User user) throws Exception {
		Connection connection = DriverManager.getConnection(url, username, password);

		String sql = "insert into useraccount(username, userpassword) values (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUserName());
		statement.setString(2, user.getUserPassword());
		int affected = statement.executeUpdate();

		connection.close();
		return affected > 0;
	}

	public User findByUserName(String userUserName) throws Exception{
		User user = null;

        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from useraccount where username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userUserName);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            user = parse(resultSet);
        }
        connection.close();
        return user;
	}

	private User parse(ResultSet resultSet) throws Exception{
		long userId = resultSet.getLong("userid");
		String userName = resultSet.getString("username");
		String userPassword = resultSet.getString("userpassword");
		User user = new User(userId, userName, userPassword);
		return user;
	}
}
