package br.com.puc.boaentrega.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.puc.boaentrega.models.Mercadoria;
import br.com.puc.boaentrega.repositories.MercadoriaRepository;

@Service
public class MercadoriaManager {

	@Autowired
	private MercadoriaRepository mercadoriaRepository;
	

	public Mercadoria casdastrarMercadoria(Mercadoria mercadoria) {
		return mercadoriaRepository.insert(mercadoria);
	}
	
	public Mercadoria alterarMercadoria(Mercadoria mercadoria, Long codigo) {
		
		Mercadoria dbMercadoria = mercadoriaRepository.findByCodigo(codigo);
		
		if (null == dbMercadoria) {
			return dbMercadoria;
		}
		dbMercadoria.setCodigo(mercadoria.getCodigo());
		dbMercadoria.setPeso(mercadoria.getPeso());
		dbMercadoria.setAltura(mercadoria.getAltura());
		dbMercadoria.setLargura(mercadoria.getLargura());
		
		
		return mercadoriaRepository.save(dbMercadoria);
	}
	
	public Mercadoria buscarMercadoria(Long codigo) {
		return mercadoriaRepository.findByCodigo(codigo);
	}
	
	public void excluirMercadoria(Long codigo) {
		mercadoriaRepository.deleteByCodigo(codigo);
	}
	
}
