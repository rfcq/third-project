package br.com.iesp.projeto.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import br.com.iesp.projeto.model.Cliente;
import br.com.iesp.projeto.service.ClienteService;

@WebServlet("/deletar")
public class DeleteCliente {
	private ClienteService clienteService;
	protected void delete() throws IOException, SQLException, ClassNotFoundException {
		
		Cliente cliente = new Cliente();
		String user = null;
		cliente.setUser(user);
		
		this.clienteService.delete(cliente);
	}
}
