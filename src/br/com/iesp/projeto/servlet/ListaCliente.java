package br.com.iesp.projeto.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iesp.projeto.model.Cliente;
import br.com.iesp.projeto.service.ClienteService;

@WebServlet("/listaCliente")
public class ListaCliente extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ClienteService clienteService;
	
	public void init() throws ServletException {
		this.clienteService = new ClienteService();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher("exibir.jsp");
		
		List<Cliente> clientes = this.clienteService.showInfo();
		
		req.setAttribute("clientes", clientes);
		
		dispatch.forward(req, resp);
	}
}
