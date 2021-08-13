package pl.AP.wet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wlascicel")
public class Wlasciciel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "imie", nullable = false)
	private String Imie;
	
	@Column(name = "nazwisko", nullable = false)
	private String Nazwisko;
	
	@Column(name = "telefon", nullable = false)
	private String Telefon;

	public Wlasciciel() {
		super();
	}

	public Wlasciciel(String imie, String nazwisko, String telefon) {
		super();
		Imie = imie;
		Nazwisko = nazwisko;
		Telefon = telefon;
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

	public String getNazwisko() {
		return Nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		Nazwisko = nazwisko;
	}

	public String getTelefon() {
		return Telefon;
	}

	public void setTelefon(String telefon) {
		Telefon = telefon;
	}
	
	
}
