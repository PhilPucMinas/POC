package br.com.puc.boaentrega.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.puc.boaentrega.models.Mercadoria;

public interface MercadoriaRepository extends MongoRepository<Mercadoria, String>{

	Mercadoria findByCodigo(Long codigo);
	void deleteByCodigo(Long codigo);
	
}
