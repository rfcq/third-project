package br.com.iesp.projeto.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iesp.projeto.service.ClienteService;

@WebServlet("/deletar")
public class DeleteCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ClienteService clienteService;
	
	public void init() throws ServletException {
		this.clienteService = new ClienteService();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user = req.getParameter("user");
		
		try {
			this.clienteService.delete(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
