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
@Table(name="Truong")
public class Truong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matruong;
	
	@Column(name="tentruong",nullable=false)
	private String tentruong;

	@OneToMany(mappedBy="truong")
	private List<Diemtruong> diemtruongs;
	
	public int getMatruong() {
		return matruong;
	}

	public void setMatruong(int matruong) {
		this.matruong = matruong;
	}

	public List<Diemtruong> getDiemtruongs() {
		return diemtruongs;
	}

	public void setDiemtruongs(List<Diemtruong> diemtruongs) {
		this.diemtruongs = diemtruongs;
	}

	public String getTentruong() {
		return tentruong;
	}

	public void setTentruong(String tentruong) {
		this.tentruong = tentruong;
	}
	
	
}
