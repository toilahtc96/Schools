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
@Table(name="khuonvien")
public class Khuonvien {
	@Id
	private int makhuonvien;
	@Column(name="duoccap",nullable= true)
	private double duoccap;
	@Column(name="dithue",nullable= true)
	private double dithue;
	@Column(name="sanchoi",nullable= true)
	private double sanchoi;
	@Column(name="santap",nullable= true)
	private double santap;
	@Column(name="dieukienngoaitroi",nullable= true)
	private boolean dieukienngoaitroi;
	@Column(name="soluonvuon",nullable= true)
	private int soluonvuon;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cosovatchat")
	private Cosovatchat cosovatchat;

	public Khuonvien(){}
	public Khuonvien(double a,double b,double c,double d,int e,boolean f){
		this.dithue=a;
		this.duoccap=b;
		this.sanchoi=c;
		this.santap=d;
		this.soluonvuon=e;
		this.dieukienngoaitroi=f;
		
	}
	
	public int getMakhuonvien() {
		return makhuonvien;
	}

	public void setMakhuonvien(int makhuonvien) {
		this.makhuonvien = makhuonvien;
	}

	public double getDuoccap() {
		return duoccap;
	}

	public void setDuoccap(double duoccap) {
		this.duoccap = duoccap;
	}

	public double getDithue() {
		return dithue;
	}

	public void setDithue(double dithue) {
		this.dithue = dithue;
	}

	public double getSanchoi() {
		return sanchoi;
	}

	public void setSanchoi(double sanchoi) {
		this.sanchoi = sanchoi;
	}

	public double getSantap() {
		return santap;
	}

	public void setSantap(double santap) {
		this.santap = santap;
	}

	public boolean isDieukienngoaitroi() {
		return dieukienngoaitroi;
	}

	public void setDieukienngoaitroi(boolean dieukienngoaitroi) {
		this.dieukienngoaitroi = dieukienngoaitroi;
	}

	public int getSoluonvuon() {
		return soluonvuon;
	}

	public void setSoluonvuon(int soluonvuon) {
		this.soluonvuon = soluonvuon;
	}

	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}

	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}
	
	

}
