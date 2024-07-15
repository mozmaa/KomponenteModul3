package test.web.dto;

public class RacunDTO {

	private Long id;
	
	private String datumIVremeKupovine;
	
	private Long komponentaId;
	
	private String komponentaModel;

	public RacunDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatumIVremeKupovine() {
		return datumIVremeKupovine;
	}

	public void setDatumIVremeKupovine(String datumIVremeKupovine) {
		this.datumIVremeKupovine = datumIVremeKupovine;
	}

	public Long getKomponentaId() {
		return komponentaId;
	}

	public void setKomponentaId(Long komponentaId) {
		this.komponentaId = komponentaId;
	}

	public String getKomponentaModel() {
		return komponentaModel;
	}

	public void setKomponentaModel(String komponentaModel) {
		this.komponentaModel = komponentaModel;
	}
	
	
}
