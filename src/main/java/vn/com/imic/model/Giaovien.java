package vn.com.imic.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;

@Entity
@Table(name="Giaovien")
public class Giaovien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int magiaovien;

	@Column(name="ten",nullable=false)

	private String ten;

	@Column(name="ngaysinh",nullable=false)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past
	private Date ngaysinh;
	
	@Column(name="diachi",nullable=false)

	private String diachi;
	
	@Column(name="quequan",nullable=false)
	private String quequan;
	
	@Column(name="email",nullable=false)

	private String email;
	
	
	@Column(name="sdt",nullable=false)
	private String sdt;
	
	@Column(name="namvaonghe",nullable=false)
	private int namvaonghe;
	
	@Column(name="trinhdo",nullable=false)
	private String trinhdo;

	@OneToMany(mappedBy = "chunhiem",fetch=FetchType.LAZY)
	private List<Khoahoc> khoahoc;

	@OneToMany(mappedBy = "giaovien",fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	private List<Giangday> giangday;

	@ManyToOne
	private Diemtruong diemtruong;
	
	public int getMagiaovien() {
		return magiaovien;
	}

	public void setMagiaovien(int magiaovien) {
		this.magiaovien = magiaovien;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getNamvaonghe() {
		return namvaonghe;
	}

	public void setNamvaonghe(int namvaonghe) {
		this.namvaonghe = namvaonghe;
	}

	public String getTrinhdo() {
		return trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}

	public List<Khoahoc> getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(List<Khoahoc> khoahoc) {
		this.khoahoc = khoahoc;
	}

	public List<Giangday> getGiangday() {
		return giangday;
	}

	public void setGiangday(List<Giangday> giangday) {
		this.giangday = giangday;
	}

	public Diemtruong getDiemtruong() {
		return diemtruong;
	}

	public void setDiemtruong(Diemtruong diemtruong) {
		this.diemtruong = diemtruong;
	}
	
	
}
