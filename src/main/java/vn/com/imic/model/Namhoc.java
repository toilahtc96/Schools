package vn.com.imic.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Namhoc")
public class Namhoc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int manamhoc;
	
	@Column(name="thoigian",nullable=false)
	private String thoigian;

	@OneToMany(mappedBy="namhoc")
	private List<Khoahoc> khoahoc;

	public int getManamhoc() {
		return manamhoc;
	}

	public void setManamhoc(int manamhoc) {
		this.manamhoc = manamhoc;
	}

	public String getThoigian() {
		return thoigian;
	}

	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}

	public List<Khoahoc> getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(List<Khoahoc> khoahoc) {
		this.khoahoc = khoahoc;
	}

	public String toString(){
		return this.thoigian;
	}
	
}
