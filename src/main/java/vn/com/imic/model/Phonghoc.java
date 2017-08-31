package vn.com.imic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="phonghoc")
public class Phonghoc {
	@Id
	private int maP;
	@Column(name = "tenPhong", nullable = false)
	private String tenPhong;
	@Column(name = "capdoxd", nullable = true)
	private int capdoxd;
	@Column(name = "dientich", nullable = true)
	private double dientich;
	@Column(name = "xaymoi")
	private boolean xaymoi;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cosovatchat")
	private Cosovatchat cosovatchat;

	public Phonghoc(){};
	public Phonghoc(int a1, String a2, double b1, boolean c){
		this.capdoxd=a1;
		this.dientich=b1;
		this.tenPhong=a2;
		this.xaymoi=c;
	}
	
	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}

	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}

	public int getMaP() {
		return maP;
	}

	public void setMaP(int maP) {
		this.maP = maP;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public int getCapdoxd() {
		return capdoxd;
	}

	public void setCapdoxd(int capdoxd) {
		this.capdoxd = capdoxd;
	}

	public double getDientich() {
		return dientich;
	}

	public void setDientich(double dientich) {
		this.dientich = dientich;
	}

	public boolean isXaymoi() {
		return xaymoi;
	}

	public void setXaymoi(boolean xaymoi) {
		this.xaymoi = xaymoi;
	}

}
