package test.web.dto;

import java.util.LinkedHashMap;
import java.util.Map;

public class KomponentaDTO {

	private Long id;
	
	private String model;
	
	private String datumDostupnosti;
	
	private Double cena;
	
	private Boolean dostupnost;
	
	private String slika;
	
	private Long proizvodjacId;
	
	private String proizvodjacNaziv;
	
	private Map<Long, String> racuni = new LinkedHashMap<>();

	public KomponentaDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDatumDostupnosti() {
		return datumDostupnosti;
	}

	public void setDatumDostupnosti(String datumDostupnosti) {
		this.datumDostupnosti = datumDostupnosti;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Boolean getDostupnost() {
		return dostupnost;
	}

	public void setDostupnost(Boolean dostupnost) {
		this.dostupnost = dostupnost;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public Long getProizvodjacId() {
		return proizvodjacId;
	}

	public void setProizvodjacId(Long proizvodjacId) {
		this.proizvodjacId = proizvodjacId;
	}

	public String getProizvodjacNaziv() {
		return proizvodjacNaziv;
	}

	public void setProizvodjacNaziv(String proizvodjacNaziv) {
		this.proizvodjacNaziv = proizvodjacNaziv;
	}

	public Map<Long, String> getRacuni() {
		return racuni;
	}

	public void setRacuni(Map<Long, String> racuni) {
		this.racuni = racuni;
	}
	
	
}
