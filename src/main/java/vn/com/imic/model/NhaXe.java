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
@Table(name = "nhaxe")
public class NhaXe {
	@Id
	private int maNhaxe;
	@Column(name = "nhaxegv")
	private int nhaxegv;
	@Column(name = "nhaxehs")
	private int nhaxehs;
	@Column(name = "Sgv")
	private double Sgv;
	@Column(name = "Shs")
	private double Shs;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cosovatchat")
	private Cosovatchat cosovatchat;

	public NhaXe(){};
	public NhaXe(int a1, int a2, double b1,double b2){
		this.nhaxegv=a1;
		this.nhaxehs=a2;
		this.Sgv=b1;
		this.Shs=b2;
	}
	
	public int getNhaxegv() {
		return nhaxegv;
	}

	public void setNhaxegv(int nhaxegv) {
		this.nhaxegv = nhaxegv;
	}

	public int getNhaxehs() {
		return nhaxehs;
	}

	public void setNhaxehs(int nhaxehs) {
		this.nhaxehs = nhaxehs;
	}

	public double getSgv() {
		return Sgv;
	}

	public void setSgv(double sgv) {
		Sgv = sgv;
	}

	public double getShs() {
		return Shs;
	}

	public void setShs(double shs) {
		Shs = shs;
	}

	public int getMaNhaxe() {
		return maNhaxe;
	}

	public void setMaNhaxe(int maNhaxe) {
		this.maNhaxe = maNhaxe;
	}

	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}

	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}
}
