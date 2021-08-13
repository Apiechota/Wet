package pl.AP.wet.entity;

public class HarmonogramCount {
	
	private int Ilosc;
	
	private String Data;

	public HarmonogramCount() {
		super();
	}

	public HarmonogramCount(int ilosc, String data) {
		super();
		Ilosc = ilosc;
		Data = data;
	}

	public int getIlosc() {
		return Ilosc;
	}

	public void setIlosc(int ilosc) {
		Ilosc = ilosc;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	
	
}
