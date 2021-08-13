package pl.AP.wet.entity;


public class HarmonogramDTO {

	private Long id;
	
	private String Zabieg;
	
	private String Zwierzak;
	
	private String Data;

	public HarmonogramDTO() {
		super();
	}

	public HarmonogramDTO(Long id, String zabieg, String zwierzak, String data) {
		super();
		this.id = id;
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

	public String getZabieg() {
		return Zabieg;
	}

	public void setZabieg(String zabieg) {
		Zabieg = zabieg;
	}

	public String getZwierzak() {
		return Zwierzak;
	}

	public void setZwierzak(String zwierzak) {
		Zwierzak = zwierzak;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	
	
	
}
