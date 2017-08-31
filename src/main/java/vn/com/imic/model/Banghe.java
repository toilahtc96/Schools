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
@Table(name = "banghe")
public class Banghe {

	@Id
	private int maBanGhe;

	@Column(name = "banbon", nullable = true)
	private int banBon;
	@Column(name = "ghebon", nullable = true)
	private int gheBon;
	@Column(name = "banhai", nullable = true)
	private int banHai;
	@Column(name = "ghehai", nullable = true)
	private int gheHai;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cosovatchat")
	private Cosovatchat cosovatchat;

	public Banghe() {
	}

	public Banghe(int bb, int bh, int gb, int gh) {
		this.banBon = bb;
		this.banHai = bh;
		this.gheBon = gb;
		this.gheHai = gh;
	}

	public int getMaBanGhe() {
		return maBanGhe;
	}

	public void setMaBanGhe(int maBanGhe) {
		this.maBanGhe = maBanGhe;
	}

	public int getBanBon() {
		return banBon;
	}

	public void setBanBon(int banBon) {
		this.banBon = banBon;
	}

	public int getGheBon() {
		return gheBon;
	}

	public void setGheBon(int gheBon) {
		this.gheBon = gheBon;
	}

	public int getBanHai() {
		return banHai;
	}

	public void setBanHai(int banHai) {
		this.banHai = banHai;
	}

	public int getGheHai() {
		return gheHai;
	}

	public void setGheHai(int gheHai) {
		this.gheHai = gheHai;
	}

	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}

	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}

}
