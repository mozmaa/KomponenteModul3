package test.web.dto;

import java.util.LinkedHashMap;
import java.util.Map;


public class ProizvodjacDTO {

	private Long id;
	
	private String naziv;
	
	private String sediste;
	
	private Map<Long, String> komponente = new LinkedHashMap<>();

	public ProizvodjacDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSediste() {
		return sediste;
	}

	public void setSediste(String sediste) {
		this.sediste = sediste;
	}

	public Map<Long, String> getKomponente() {
		return komponente;
	}

	public void setKomponente(Map<Long, String> komponente) {
		this.komponente = komponente;
	}

	
}
