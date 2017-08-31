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
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="Lop")
@NamedQueries({
	@NamedQuery(name="findAll",query="from Lop"),
	@NamedQuery(name="findById",query="from Lop where malop = :malop")
})
public class Lop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int malop;
	
	@Column(name="tenlop",nullable=false)
	private String tenlop;
	
	@Column(name="sotiethoc",nullable=false)
	private int sotiethoc;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="diemtruong")
	private Diemtruong diemtruong;
	
	@OneToMany(mappedBy="lop")
	private List<Khoahoc> khoahoc;

	public int getMalop() {
		return malop;
	}

	public void setMalop(int malop) {
		this.malop = malop;
	}

	public String getTenlop() {
		return tenlop;
	}

	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}

	public int getSotiethoc() {
		return sotiethoc;
	}

	public void setSotiethoc(int sotiethoc) {
		this.sotiethoc = sotiethoc;
	}

	public Diemtruong getDiemtruong() {
		return diemtruong;
	}

	public void setDiemtruong(Diemtruong diemtruong) {
		this.diemtruong = diemtruong;
	}

	public List<Khoahoc> getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(List<Khoahoc> khoahoc) {
		this.khoahoc = khoahoc;
	}


	
}