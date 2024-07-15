package test.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Proizvodjac {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private String sediste;
	
	 @OneToMany(mappedBy = "proizvodjac", fetch = FetchType.EAGER)
	private List<Komponenta> komponente = new ArrayList<>();

	public Proizvodjac() {
	}

	@Override
	public String toString() {
		return "Proizvodjac [id=" + id + ", naziv=" + naziv + ", sediste=" + sediste + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proizvodjac other = (Proizvodjac) obj;
		return Objects.equals(id, other.id);
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

	public List<Komponenta> getKomponente() {
		return komponente;
	}

	public void setKomponente(List<Komponenta> komponente) {
		this.komponente = komponente;
	}

	
}
