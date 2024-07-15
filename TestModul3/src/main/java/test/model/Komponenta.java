package test.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Komponenta {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String model;
	
	@Column
	private LocalDate datumDostupnosti;
	
	@Column
	private double cena;
	
	@Column
	private boolean dostupnost;
	
	@Column
	private String slika;
	
	@ManyToOne
	private Proizvodjac proizvodjac;
	
	@OneToMany(mappedBy = "komponenta", fetch = FetchType.EAGER)
	private List<Racun> racuni= new ArrayList<>();

	public Komponenta() {
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

	public LocalDate getDatumDostupnosti() {
		return datumDostupnosti;
	}

	public void setDatumDostupnosti(LocalDate datumDostupnosti) {
		this.datumDostupnosti = datumDostupnosti;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public boolean isDostupnost() {
		return dostupnost;
	}

	public void setDostupnost(boolean dostupnost) {
		this.dostupnost = dostupnost;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public List<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
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
		Komponenta other = (Komponenta) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Komponenta [id=" + id + ", model=" + model + ", datumDostupnosti=" + datumDostupnosti + ", cena=" + cena
				+ ", dostupnost=" + dostupnost + ", slika=" + slika + "]";
	}
	
	
}
