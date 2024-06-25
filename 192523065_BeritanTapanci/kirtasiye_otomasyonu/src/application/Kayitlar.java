//package application
//
//public class Kayitlar {
// private int barkod_no;
// private String kategori,urun_adi;
// private double alis_fiyati,satis_fiyati;
// private int stok;
//Kayitlar(){
//	
//}

package application;

public class Kayitlar {

	private int barkod_no;
	private String kategori;
	private String urun_adi;
	private Double alis_fiyati;
	private Double satis_fiyati;
	private int stok;
	
	

	public  Kayitlar(int barkod_no, String kategori, String urun_adi,
			Double alis_fiyati, Double satis_fiyati, int stok
			) {
		this.barkod_no=barkod_no;
		this.kategori=kategori;
		this.urun_adi=urun_adi;
		this.alis_fiyati=alis_fiyati;
		this.satis_fiyati=satis_fiyati;
		this.stok=stok;
		
	}
	public int getBarkod_no() {
		return barkod_no;
	}
	public void setBarkod_no(int barkod_no) {
		this.barkod_no = barkod_no;
	}
	public String getKategori() {
		return kategori;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public String getUrun_adi() {
		return urun_adi;
	}
	public void setUrun_adi(String urun_adi) {
		this.urun_adi = urun_adi;
	}
	public Double getAlis_fiyati() {
		return alis_fiyati;
	}
	public void setAlis_fiyati(Double alis_fiyati) {
		this.alis_fiyati = alis_fiyati;
	}
	public Double getSatis_fiyati() {
		return satis_fiyati;
	}
	public void setSatis_fiyati(Double satis_fiyati) {
		this.satis_fiyati = satis_fiyati;
	}
	public int getStok() {
		return stok;
	}
	public void setStok(int stok) {
		this.stok = stok;
	}
	public int getText() {
		// TODO Auto-generated method stub
		return 0;
	}
}
