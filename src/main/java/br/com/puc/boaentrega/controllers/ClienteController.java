package br.com.puc.boaentrega.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.puc.boaentrega.models.Cliente;
import br.com.puc.boaentrega.services.ClienteManager;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private ClienteManager clienteManager;
	
	@Operation(summary = "Cadastramento de Clientes")
	@PostMapping("/")
	public ResponseEntity<Cliente> casdastrarCliente(@RequestBody Cliente cliente) throws URISyntaxException {
	    
		Cliente clienteCadastrado = clienteManager.casdastrarCliente(cliente);
	    
		if (null == clienteCadastrado) {
	        return ResponseEntity.notFound().build();
	    } else {
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	          .path("/{cpf}")
	          .buildAndExpand(clienteCadastrado.getCpf())
	          .toUri();

	        return ResponseEntity.created(uri).body(clienteCadastrado);
	    }
	}
	
	@Operation(summary = "Alteração de Clientes")
	@PutMapping("/{cpf}")
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente, @PathVariable String cpf) {
	    
		Cliente clienteAlterado = clienteManager.alterarCliente(cliente, cpf);
	    
		if (null == clienteAlterado) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(clienteAlterado);
	    }
	}
	
	@Operation(summary = "Consulta de Clientes")
	@GetMapping("/{cpf}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable("cpf") String cpf) {
	    
		Cliente clienteEncontrado = clienteManager.buscarCliente(cpf);
	    
		if (null == clienteEncontrado) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(clienteEncontrado);
	    }
	}
}