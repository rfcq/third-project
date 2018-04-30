package br.com.iesp.projeto.filter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.iesp.projeto.connection.ConnectionFactory;

public class doFilter {
	
	private static Connection con;
	
	static boolean status = false;
	public static boolean validation(String login, String pass) {
	try {
		con = ConnectionFactory.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE USERN=? and PAWD=?");
		
		ps.setString(1, login);
		ps.setString(2, pass);
		
		ResultSet rs = ps.executeQuery();
		status = rs.next();
	} catch (Exception e) {
		System.out.println(e);
	}
	return status;
}
}
