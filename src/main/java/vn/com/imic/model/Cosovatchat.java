package vn.com.imic.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cosovatchat")
public class Cosovatchat {
	@Id
	private int macosovatchat;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "diemtruong")
	private Diemtruong diemtruong;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "banghe")
	private Banghe banghe;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "phonghoc")
	private Phonghoc phongHoc;

	public Phonghoc getPhongHoc() {
		return phongHoc;
	}

	public void setPhongHoc(Phonghoc phongHoc) {
		this.phongHoc = phongHoc;
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "nhaxe")
	private NhaXe nhaXe;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "nhavesinh")
	private Nhavesinh nhavesinh;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "thietbi")
	private Thietbi thietbi;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "khuonvien")
	private Khuonvien khuonvien;

	public Khuonvien getKhuonvien() {
		return khuonvien;
	}

	public void setKhuonvien(Khuonvien khuonvien) {
		this.khuonvien = khuonvien;
	}

	public NhaXe getNhaXe() {
		return nhaXe;
	}

	public void setNhaXe(NhaXe nhaXe) {
		this.nhaXe = nhaXe;
	}

	public Nhavesinh getNhavesinh() {
		return nhavesinh;
	}

	public Banghe getBanghe() {
		return banghe;
	}

	public void setBanghe(Banghe banghe) {
		this.banghe = banghe;
	}

	public void setNhavesinh(Nhavesinh nhavesinh) {
		this.nhavesinh = nhavesinh;
	}

	public Thietbi getThietbi() {
		return thietbi;
	}

	public void setThietbi(Thietbi thietbi) {
		this.thietbi = thietbi;
	}

	public int getMacosovatchat() {
		return macosovatchat;
	}

	public void setMacosovatchat(int macosovatchat) {
		this.macosovatchat = macosovatchat;
	}

	public Diemtruong getDiemtruong() {
		return diemtruong;
	}

	public void setDiemtruong(Diemtruong diemtruong) {
		this.diemtruong = diemtruong;
	}

}
