package pl.AP.wet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "zabieg")
public class Zabieg {
	@Id
	
	private Long id;
	
	@Column(name = "nazwa_zabiegu", nullable = false)
	private String NazwaZabiegu;
	
	
	@Column(name = "opis", nullable = false)
	private String Opis;


	public Zabieg() {
		super();
	}


	public Zabieg(String nazwaZabiegu, String opis) {
		super();
		NazwaZabiegu = nazwaZabiegu;
		Opis = opis;
	}


	public Zabieg(Long id, String nazwaZabiegu, String opis) {
		super();
		this.id = id;
		NazwaZabiegu = nazwaZabiegu;
		Opis = opis;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNazwaZabiegu() {
		return NazwaZabiegu;
	}


	public void setNazwaZabiegu(String nazwaZabiegu) {
		NazwaZabiegu = nazwaZabiegu;
	}


	public String getOpis() {
		return Opis;
	}


	public void setOpis(String opis) {
		Opis = opis;
	}
	
}
