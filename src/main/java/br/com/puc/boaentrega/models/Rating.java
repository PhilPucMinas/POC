package br.com.puc.boaentrega.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ratings")
public class Rating {

	@Id
	private String id;
	private String nomeCliente;
	private Long protocolo;
	private Double rating;
	private String nomeAtendente;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Long getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(Long protocolo) {
		this.protocolo = protocolo;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getNomeAtendente() {
		return nomeAtendente;
	}
	public void setNomeAtendente(String nomeAtendente) {
		this.nomeAtendente = nomeAtendente;
	}
}
