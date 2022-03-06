package br.com.puc.boaentrega.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.puc.boaentrega.models.Mercadoria;
import br.com.puc.boaentrega.services.MercadoriaManager;

@RestController
@RequestMapping("mercadoria")
public class MercadoriaController {

	@Autowired
	private MercadoriaManager mercadoriaManager;
	
	@PostMapping("/")
	public ResponseEntity<Mercadoria> casdastrarMercadoria(@RequestBody Mercadoria mercadoria) throws URISyntaxException {
	    
		Mercadoria mercadoriaCadastrada = mercadoriaManager.casdastrarMercadoria(mercadoria);
	    
		if (null == mercadoriaCadastrada) {
	        return ResponseEntity.notFound().build();
	    } else {
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	          .path("/{cpf}")
	          .buildAndExpand(mercadoriaCadastrada.getCodigo())
	          .toUri();

	        return ResponseEntity.created(uri).body(mercadoriaCadastrada);
	    }
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Mercadoria> alterarMercadoria(@RequestBody Mercadoria mercadoria, @PathVariable Long codigo) {
	    
		Mercadoria mercadoriaAlterada = mercadoriaManager.alterarMercadoria(mercadoria, codigo);
	    
		if (null == mercadoriaAlterada) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(mercadoriaAlterada);
	    }
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Mercadoria> buscarMercadoria(@PathVariable("codigo") Long codigo) {
	    
		Mercadoria mercadoriaEncontrada = mercadoriaManager.buscarMercadoria(codigo);
	    
		if (null == mercadoriaEncontrada) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(mercadoriaEncontrada);
	    }
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Mercadoria> excluirMercadoria(@PathVariable Long codigo) {
	    mercadoriaManager.excluirMercadoria(codigo);
	    return ResponseEntity.noContent().build();
	}
}