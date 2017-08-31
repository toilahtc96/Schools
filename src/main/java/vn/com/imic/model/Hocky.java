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
@Table(name="Hocky")
public class Hocky {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mahocky;
	
	@Column(name="tenhocky",nullable=false)
	private String tenhocky;
	
	@OneToMany(mappedBy="hocky")
	private List<Khoahoc> khoahoc;

	public int getMahocky() {
		return mahocky;
	}

	public void setMahocky(int mahocky) {
		this.mahocky = mahocky;
	}

	public String getTenhocky() {
		return tenhocky;
	}

	public void setTenhocky(String tenhocky) {
		this.tenhocky = tenhocky;
	}

	public List<Khoahoc> getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(List<Khoahoc> khoahoc) {
		this.khoahoc = khoahoc;
	}
	
	public String toString(){
		return this.tenhocky;
	}

}
