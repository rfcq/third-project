package br.com.iesp.projeto.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iesp.projeto.model.Cliente;
import br.com.iesp.projeto.service.ClienteService;

@WebServlet("/cadastrar")
public class ClienteAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteService clienteService;
	
	@Override
	public void init() throws ServletException {
		this.clienteService = new ClienteService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String senha = req.getParameter("senha");
		
		Cliente cliente = new Cliente();
		cliente.setUser(user);
		cliente.setPasswd(senha);
		
		try {
			this.clienteService.save(cliente);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
