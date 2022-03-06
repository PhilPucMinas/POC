package br.com.puc.boaentrega.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.puc.boaentrega.models.Rating;

public interface RatingRepository extends MongoRepository<Rating, String>{

	@Query(value = "{rating: {$gt: 2.5}}", count = true)
	Long buscarQtdHighRating();
	@Query(value = "{rating: {$lt: 2.6}}", count = true)
	Long buscarQtdLowRating();
	
}
