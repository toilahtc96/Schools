package vn.com.imic.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Hocsinh")
public class Hocsinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maso;
	
	@Column(name="ten",nullable=false)
	private String ten;
	
	@Column(name="ngaysinh",nullable=false)
	private Date ngaysinh;
	
	@Column(name="diachi",nullable=false)
	private String diachi;
	
	@Column(name="quequan",nullable=false)
	private String quequan;
	
	@Column(name="bo")
	private String bo;
	
	@Column(name="me")
	private String me;

	@ManyToMany(mappedBy="hocsinh")
	private List<Khoahoc> khoahoc;
	
	public int getMaso() {
		return maso;
	}

	public void setMaso(int maso) {
		this.maso = maso;
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

	public String getBo() {
		return bo;
	}

	public void setBo(String bo) {
		this.bo = bo;
	}

	public String getMe() {
		return me;
	}

	public void setMe(String me) {
		this.me = me;
	}

	public List<Khoahoc> getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(List<Khoahoc> khoahoc) {
		this.khoahoc = khoahoc;
	}
	
	
}
