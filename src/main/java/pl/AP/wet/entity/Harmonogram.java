package pl.AP.wet.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "harmonogram")
public class Harmonogram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_zabiegu", nullable = false)
	private int Zabieg;
	
	@Column(name = "id_zwierzaka", nullable = false)
	private int Zwierzak;
	
	@Column(name = "data", nullable = false)
	private String Data;

	public Harmonogram() {
		super();
	}

	public Harmonogram(int zabieg, int zwierzak, String data) {
		super();
		Zabieg = zabieg;
		Zwierzak = zwierzak;
		Data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getZabieg() {
		return Zabieg;
	}

	public void setZabieg(int zabieg) {
		Zabieg = zabieg;
	}

	public int getZwierzak() {
		return Zwierzak;
	}

	public void setZwierzak(int zwierzak) {
		Zwierzak = zwierzak;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}
	
	
}
