package br.com.puc.boaentrega.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.puc.boaentrega.models.Rating;
import br.com.puc.boaentrega.services.RatingManager;

@RestController
@RequestMapping("rating")
public class RatingController {

	@Autowired
	private RatingManager ratingManager;
	
	@PostMapping("/")
	public ResponseEntity<Rating> casdastrarRating(@RequestBody Rating rating) throws URISyntaxException {
	    
		Rating ratingCadastrado = ratingManager.casdastrarRating(rating);
	    
		if (null == ratingCadastrado) {
	        return ResponseEntity.notFound().build();
	    } else {
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	          .path("/{protocolo}")
	          .buildAndExpand(ratingCadastrado.getProtocolo())
	          .toUri();

	        return ResponseEntity.created(uri).body(ratingCadastrado);
	    }
	}
	
	@GetMapping("/high")
	public ResponseEntity<Long> buscarQtdHighRating() {
	    
		Long highRatingEncontrado = ratingManager.buscarQtdHighRating();
	    
		if (null == highRatingEncontrado) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(highRatingEncontrado);
	    }
	}
	
	@GetMapping("/low")
	public ResponseEntity<Long> buscarQtdLowRating() {
	    
		Long lowRatingEncontrado = ratingManager.buscarQtdLowRating();
	    
		if (null == lowRatingEncontrado) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(lowRatingEncontrado);
	    }
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> buscarAllRating() {
	    
		List<Rating> allRatingEncontrado = ratingManager.buscarAllRating();
	    
		if (allRatingEncontrado.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(allRatingEncontrado);
	    }
	}
	

}