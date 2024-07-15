package test.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Racun {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private LocalDateTime datumIVremeKupovine;
	
	@ManyToOne
	private Komponenta komponenta;

	public Racun() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatumIVremeKupovine() {
		return datumIVremeKupovine;
	}

	public void setDatumIVremeKupovine(LocalDateTime datumIVremeKupovine) {
		this.datumIVremeKupovine = datumIVremeKupovine;
	}

	public Komponenta getKomponenta() {
		return komponenta;
	}

	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
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
		Racun other = (Racun) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Racun [id=" + id + ", datumIVremeKupovine=" + datumIVremeKupovine + "]";
	}
	
	
}
