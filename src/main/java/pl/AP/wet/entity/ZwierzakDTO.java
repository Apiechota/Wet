package pl.AP.wet.entity;



public class ZwierzakDTO {

	private Long id;

	private String Imie;

	private String Wlascicielid;

	private String Gatunek;
	
	
	public ZwierzakDTO() {
		super();
	}


	public ZwierzakDTO(Long id, String imie, String wlascicielid, String gatunek) {
		super();
		this.id = id;
		Imie = imie;
		Wlascicielid = wlascicielid;
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


	public String getWlascicielid() {
		return Wlascicielid;
	}


	public void setWlascicielid(String wlascicielid) {
		Wlascicielid = wlascicielid;
	}


	public String getGatunek() {
		return Gatunek;
	}


	public void setGatunek(String gatunek) {
		Gatunek = gatunek;
	}



}
