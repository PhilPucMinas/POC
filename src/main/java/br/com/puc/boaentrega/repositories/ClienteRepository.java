package br.com.puc.boaentrega.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.puc.boaentrega.models.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{

	Cliente findByCpf(String cpf);
	
}
