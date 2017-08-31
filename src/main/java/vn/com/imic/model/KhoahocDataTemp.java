package vn.com.imic.model;

public class KhoahocDataTemp {
	private int namhoc;
	private int hocki;
	private int diemtruong;
	
	
	public KhoahocDataTemp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public KhoahocDataTemp(int namhoc, int hocki, int diemtruong) {
		super();
		this.namhoc = namhoc;
		this.hocki = hocki;
		this.diemtruong = diemtruong;
	}



	public int getNamhoc() {
		return namhoc;
	}
	public void setNamhoc(int namhoc) {
		this.namhoc = namhoc;
	}
	public int getHocki() {
		return hocki;
	}
	public void setHocki(int hocki) {
		this.hocki = hocki;
	}
	public int getDiemtruong() {
		return diemtruong;
	}
	public void setDiemtruong(int diemtruong) {
		this.diemtruong = diemtruong;
	}
	
	
}
