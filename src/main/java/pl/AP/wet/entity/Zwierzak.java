package pl.AP.wet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zwierzak")
public class Zwierzak {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "imie", nullable = false)
	private String Imie;
	
	@Column(name = "id_wlasciciel", nullable = false)
	private int Wlasciciel;
	
	@Column(name = "gatunek", nullable = false)
	private String Gatunek;
	
	
	public Zwierzak() {
		super();
	}

	public Zwierzak(String imie, int wlasciciel, String gatunek) {
		super();
		Imie = imie;
		Wlasciciel = wlasciciel;
		Gatunek = gatunek;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImie() {
		return Imie;
	}

	public void setImie(String imie) {
		Imie = imie;
	}

	public int getWlasciciel() {
		return Wlasciciel;
	}

	public void setWlasciciel(int wlasciciel) {
		Wlasciciel = wlasciciel;
	}

	public String getGatunek() {
		return Gatunek;
	}

	public void setGatunek(String gatunek) {
		Gatunek = gatunek;
	}


}
