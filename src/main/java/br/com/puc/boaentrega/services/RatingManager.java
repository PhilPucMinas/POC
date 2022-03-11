package br.com.puc.boaentrega.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Map<String, Long> buscarQtdHighRating() {
		
		Map<String, Long> qtdRating = new HashMap<>();
		
		Long qtdHighRating = ratingRepository.buscarQtdHighRating();
		qtdRating.put("qtdHighRating", qtdHighRating);
		
		return qtdRating;
	}

	public Map<String, Long> buscarQtdLowRating() {
		
		Map<String, Long> qtdRating = new HashMap<>();
		
		Long qtdLowRating = ratingRepository.buscarQtdLowRating();
		qtdRating.put("qtdLowRating", qtdLowRating);
		
		return qtdRating;
	}
	
	public List<Rating> buscarAllRating() {
		return ratingRepository.findAll();
	}
	
}
