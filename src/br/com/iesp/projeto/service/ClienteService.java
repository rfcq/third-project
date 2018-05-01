package br.com.iesp.projeto.service;

import java.sql.SQLException;
import java.util.List;

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
	
	public Cliente delete(String id) throws ClassNotFoundException, SQLException {
		
		this.clienteRepository.delete(id);
		return null;
	}
	
	public List<Cliente> showInfo(){
		return this.clienteRepository.showInfo();
	}

	
}
