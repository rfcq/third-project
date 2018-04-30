package br.com.iesp.projeto.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		try {
		stmt = con.prepareStatement("DELETE FROM users WHERE USERN = ?");
		stmt.setInt(1, cliente.getId());
		stmt.execute();
		con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cliente> showInfo() {
		List<Cliente> listCliente = new ArrayList<Cliente>();
		
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setUser(rs.getString(1));
				c.setPasswd(rs.getString(2));
				listCliente.add(c);
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listCliente;
	}
}
