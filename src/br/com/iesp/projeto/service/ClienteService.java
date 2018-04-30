package br.com.iesp.projeto.service;

import java.sql.SQLException;

import br.com.iesp.projeto.model.Cliente;
import br.com.iesp.projeto.repository.ClienteRepository;

public class ClienteService {

	private ClienteRepository clienteRepository;
	
	public ClienteService() {
		this.clienteRepository = new ClienteRepository();
	}
	
	public void save(Cliente cliente) throws ClassNotFoundException {
		this.clienteRepository.save(cliente);
	}
	
	public void delete(Cliente user) throws ClassNotFoundException, SQLException {
		Cliente id = null;
		this.clienteRepository.delete(id);
	}
}
