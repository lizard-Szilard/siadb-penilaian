package main;

public class Penilaian {

	private String id;
	private String nama;
	private Integer PenilaianAngka;
	private String nilaianHuruf;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Integer getNilaiAngka() {
		return PenilaianAngka;
	}

	public void setNilaiAngka(Integer PenilaianAngka) {
		this.PenilaianAngka = PenilaianAngka;
	}

	public String getPenilaianHuruf() {
		return nilaianHuruf;
	}

	public void setPenilaianHuruf(String nilaianHuruf) {
		this.nilaianHuruf = nilaianHuruf;
	}

}
