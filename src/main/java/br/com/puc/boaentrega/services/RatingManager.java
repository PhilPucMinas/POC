package br.com.puc.boaentrega.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.puc.boaentrega.models.Rating;
import br.com.puc.boaentrega.repositories.RatingRepository;

@Service
public class RatingManager {
	
	@Autowired
	private RatingRepository ratingRepository;

	public Rating casdastrarRating(Rating rating) {
		return ratingRepository.insert(rating);
	}

	public Long buscarQtdHighRating() {
		return ratingRepository.buscarQtdHighRating();
	}

	public Long buscarQtdLowRating() {
		return ratingRepository.buscarQtdLowRating();
	}
	
	public List<Rating> buscarAllRating() {
		return ratingRepository.findAll();
	}
	
}
