package vn.com.imic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Giangday")
public class Giangday {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int magiangday;

	@ManyToOne
	private Giaovien giaovien;

	@ManyToOne
	private Monhoc monhoc;

	@ManyToOne
	private Khoahoc khoahoc;

	public int getMagiangday() {
		return magiangday;
	}

	public void setMagiangday(int magiangday) {
		this.magiangday = magiangday;
	}

	public Giaovien getGiaovien() {
		return giaovien;
	}

	public void setGiaovien(Giaovien giaovien) {
		this.giaovien = giaovien;
	}

	public Monhoc getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(Monhoc monhoc) {
		this.monhoc = monhoc;
	}

	public Khoahoc getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(Khoahoc khoahoc) {
		this.khoahoc = khoahoc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((khoahoc == null) ? 0 : khoahoc.hashCode());
		result = prime * result + ((monhoc == null) ? 0 : monhoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Giangday other = (Giangday) obj;
		if (khoahoc == null) {
			if (other.khoahoc != null)
				return false;
		} else if (!khoahoc.equals(other.khoahoc))
			return false;
		if (monhoc == null) {
			if (other.monhoc != null)
				return false;
		} else if (!monhoc.equals(other.monhoc))
			return false;
		return true;
	}

}
