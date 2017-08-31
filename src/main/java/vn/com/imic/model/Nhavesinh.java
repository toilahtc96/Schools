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
@Table(name = "nhavesinh")
public class Nhavesinh {
	@Id
	private int maNvs;

	@Column(name = "gvnamdatchuan")
	private int gvnamdatchuan;
	@Column(name = "gvnudatchuan")
	private int gvnudatchuan;
	@Column(name = "hsnamdatchuan")
	private int hsnamdatchuan;
	@Column(name = "hsnudatchuan")
	private int hsnudatchuan;
	@Column(name = "gvnamchuadatchuan")
	private int gvnamchuadatchuan;
	@Column(name = "gvnuchuadatchuan")
	private int gvnuchuadatchuan;
	@Column(name = "hsnamchuadatchuan")
	private int hsnamchuadatchuan;
	@Column(name = "hsnuchuadatchuan")
	private int hsnuchuadatchuan;

	@Column(name = "dtgvnamchuan")
	private double Sgvnamchuan;
	@Column(name = "dtgvnnuchuan")
	private double Sgvnnuchuan;
	@Column(name = "dtgvnamchuachuan")
	private double Sgvnamchuachuan;
	@Column(name = "dtgvnuchuachuan")
	private double Sgvnuchuachuan;
	@Column(name = "dthsnamchuan")
	private double Shsnamchuan;
	@Column(name = "dthsnuchuan")
	private double Shsnuchuan;
	@Column(name = "dthsnamchuachuan")
	private double Shsnamchuachuan;
	@Column(name = "dthsnuchuachuan")
	private double Shsnuchuachuan;

	public Nhavesinh() {
	};

	public Nhavesinh(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8, double b1, double b2, double b3,
			double b4, double b5, double b6, double b7, double b8) {
		this.gvnamchuadatchuan=a1;
		this.gvnamdatchuan=a2;
		this.gvnuchuadatchuan=a3;
		this.gvnudatchuan=a4;
		this.hsnamchuadatchuan=a5;
		this.hsnamdatchuan=a6;
		this.hsnuchuadatchuan=a7;
		this.hsnudatchuan=a8;
		this.Sgvnamchuachuan=b1;
		this.Sgvnamchuan=b2;
		this.Sgvnnuchuan=b3;
		this.Sgvnuchuachuan=b4;
		this.Shsnamchuachuan=b5;
		this.Shsnamchuan=b6;
		this.Shsnuchuachuan=b7;
		this.Shsnuchuan=b8;
	}

	public int getGvnamdatchuan() {
		return gvnamdatchuan;
	}

	public void setGvnamdatchuan(int gvnamdatchuan) {
		this.gvnamdatchuan = gvnamdatchuan;
	}

	public int getGvnudatchuan() {
		return gvnudatchuan;
	}

	public void setGvnudatchuan(int gvnudatchuan) {
		this.gvnudatchuan = gvnudatchuan;
	}

	public int getHsnamdatchuan() {
		return hsnamdatchuan;
	}

	public void setHsnamdatchuan(int hsnamdatchuan) {
		this.hsnamdatchuan = hsnamdatchuan;
	}

	public int getHsnudatchuan() {
		return hsnudatchuan;
	}

	public void setHsnudatchuan(int hsnudatchuan) {
		this.hsnudatchuan = hsnudatchuan;
	}

	public int getGvnamchuadatchuan() {
		return gvnamchuadatchuan;
	}

	public void setGvnamchuadatchuan(int gvnamchuadatchuan) {
		this.gvnamchuadatchuan = gvnamchuadatchuan;
	}

	public int getGvnuchuadatchuan() {
		return gvnuchuadatchuan;
	}

	public void setGvnuchuadatchuan(int gvnuchuadatchuan) {
		this.gvnuchuadatchuan = gvnuchuadatchuan;
	}

	public int getHsnamchuadatchuan() {
		return hsnamchuadatchuan;
	}

	public void setHsnamchuadatchuan(int hsnamchuadatchuan) {
		this.hsnamchuadatchuan = hsnamchuadatchuan;
	}

	public int getHsnuchuadatchuan() {
		return hsnuchuadatchuan;
	}

	public void setHsnuchuadatchuan(int hsnuchuadatchuan) {
		this.hsnuchuadatchuan = hsnuchuadatchuan;
	}

	public double getSgvnamchuan() {
		return Sgvnamchuan;
	}

	public void setSgvnamchuan(double sgvnamchuan) {
		Sgvnamchuan = sgvnamchuan;
	}

	public double getSgvnnuchuan() {
		return Sgvnnuchuan;
	}

	public void setSgvnnuchuan(double sgvnnuchuan) {
		Sgvnnuchuan = sgvnnuchuan;
	}

	public double getSgvnamchuachuan() {
		return Sgvnamchuachuan;
	}

	public void setSgvnamchuachuan(double sgvnamchuachuan) {
		Sgvnamchuachuan = sgvnamchuachuan;
	}

	public double getSgvnuchuachuan() {
		return Sgvnuchuachuan;
	}

	public void setSgvnuchuachuan(double sgvnuchuachuan) {
		Sgvnuchuachuan = sgvnuchuachuan;
	}

	public double getShsnamchuan() {
		return Shsnamchuan;
	}

	public void setShsnamchuan(double shsnamchuan) {
		Shsnamchuan = shsnamchuan;
	}

	public double getShsnuchuan() {
		return Shsnuchuan;
	}

	public void setShsnuchuan(double shsnuchuan) {
		Shsnuchuan = shsnuchuan;
	}

	public double getShsnamchuachuan() {
		return Shsnamchuachuan;
	}

	public void setShsnamchuachuan(double shsnamchuachuan) {
		Shsnamchuachuan = shsnamchuachuan;
	}

	public double getShsnuchuachuan() {
		return Shsnuchuachuan;
	}

	public void setShsnuchuachuan(double shsnuchuachuan) {
		Shsnuchuachuan = shsnuchuachuan;
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cosovatchat")
	private Cosovatchat cosovatchat;

	public int getMaNvs() {
		return maNvs;
	}

	public void setMaNvs(int maNvs) {
		this.maNvs = maNvs;
	}

	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}

	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}

}
