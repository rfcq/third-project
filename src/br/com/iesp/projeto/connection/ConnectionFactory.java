package br.com.iesp.projeto.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/SIGNUP";
		try {
			return DriverManager.getConnection(url, "rfcq", "123Test!@");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
