package br.com.iesp.projeto.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.iesp.projeto.connection.ConnectionFactory;
import br.com.iesp.projeto.model.Cliente;

public class ClienteRepository {

	private Connection con;
	
	public void save(Cliente cliente) throws ClassNotFoundException {
		this.con = ConnectionFactory.getConnection();
		
		PreparedStatement stmt;
		
		try {
			stmt = con.prepareStatement("INSERT INTO users (USERN, PAWD) VALUES (?, ?)");
			
			stmt.setString(1, cliente.getUser());
			stmt.setString(2, cliente.getPasswd());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete (Cliente cliente) throws ClassNotFoundException, SQLException {
		this.con = ConnectionFactory.getConnection();
		
		PreparedStatement stmt;
		
		stmt = con.prepareStatement("DELETE FROM users WHERE USERN = ?");
		stmt.setString(1, cliente.getUser());
		stmt.execute();
	}
}
