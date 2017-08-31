package vn.com.imic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Diemtruong")
public class Diemtruong {
	@Id
	private int madiemtruong;
	
	@Column(name="tendiemtruong",nullable=false)
	private String tendiemtruong;
	
	@Column(name="email",nullable=false)
	private String email;
	
	@Column(name="diachi",nullable=false)
	private String diachi;
	
	@Column(name="sdt",nullable=false)
	private String sdt;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="truong")
	private Truong truong;
	
	@OneToMany(mappedBy="diemtruong",cascade=CascadeType.REMOVE)
	private List<Lop> lops;
	
	@OneToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="cosovatchat",nullable=true)
	private Cosovatchat cosovatchat;

	public int getMadiemtruong() {
		return madiemtruong;
	}

	public void setMadiemtruong(int madiemtruong) {
		this.madiemtruong = madiemtruong;
	}

	public String getTendiemtruong() {
		return tendiemtruong;
	}

	public void setTendiemtruong(String tendiemtruong) {
		this.tendiemtruong = tendiemtruong;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Truong getTruong() {
		return truong;
	}

	public void setTruong(Truong truong) {
		this.truong = truong;
	}

	public List<Lop> getLops() {
		return lops;
	}

	public void setLops(List<Lop> lops) {
		this.lops = lops;
	}


	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}

	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}

	@Override
	public String toString(){
		return this.tendiemtruong;
	}
}
