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
@Table(name="thietbi")
public class Thietbi {
	@Id
	private int maTbi;
	@Column(name="mayhs")
	private int mayhs;
	@Column(name="maygv")
	private int maygv;
	@Column(name="maychieu")
	private int maychieu;
	@Column(name="internet")
	private boolean internet;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cosovatchat")
	private Cosovatchat cosovatchat;
	public Thietbi(){};
	public Thietbi(int a, int b, int c, boolean d){
		this.internet=d;
		this.maychieu=a;
		this.maygv=b;
		this.mayhs=c;
	};
	public int getMayhs() {
		return mayhs;
	}
	public void setMayhs(int mayhs) {
		this.mayhs = mayhs;
	}
	public int getMaygv() {
		return maygv;
	}
	public void setMaygv(int maygv) {
		this.maygv = maygv;
	}
	public int getMaychieu() {
		return maychieu;
	}
	public void setMaychieu(int maychieu) {
		this.maychieu = maychieu;
	}
	public int getMaTbi() {
		return maTbi;
	}
	public void setMaTbi(int maTbi) {
		this.maTbi = maTbi;
	}
	
	public boolean isInternet() {
		return internet;
	}
	public void setInternet(boolean internet) {
		this.internet = internet;
	}
	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}
	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}
}
