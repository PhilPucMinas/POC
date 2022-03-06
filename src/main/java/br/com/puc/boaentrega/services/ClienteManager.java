package br.com.puc.boaentrega.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.puc.boaentrega.models.Cliente;
import br.com.puc.boaentrega.repositories.ClienteRepository;

@Service
public class ClienteManager {

	@Autowired
	private ClienteRepository clienteRepository;
	

	public Cliente casdastrarCliente(Cliente cliente) {
		return clienteRepository.insert(cliente);
	}
	
	public Cliente alterarCliente(Cliente cliente, String cpf) {
		
		Cliente dbCliente = clienteRepository.findByCpf(cpf);
		
		if (null == dbCliente) {
			return dbCliente;
		}
		dbCliente.setCpf(cliente.getCpf());
		dbCliente.setEndereco(cliente.getEndereco());
		dbCliente.setNome(cliente.getNome());
		
		return clienteRepository.save(dbCliente);
	}
	
	public Cliente buscarCliente(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}
	
}
