package br.com.iesp.projeto.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iesp.projeto.model.Cliente;
import br.com.iesp.projeto.service.ClienteService;

@WebServlet("/deletar")
public class DeleteCliente extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteService clienteService;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		
		try {
			this.clienteService.delete(cliente.getId());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
