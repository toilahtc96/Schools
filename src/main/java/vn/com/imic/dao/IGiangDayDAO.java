package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Giangday;
import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;
import vn.com.imic.model.Monhoc;

public interface IGiangDayDAO {

	List<Giaovien> getGiaoVien(int first, int max);

	List<Monhoc> getMonHoc();

	List<Lop> getLop();

	List<Giangday> getAll();

	void saveOrUpdate(Giangday giangday);

	void delete(int magiangday);

	Giangday findByID(int magiangday);

	Giaovien getGiaoVien(int maGiaoVien);

	List<Monhoc> getMonHocs();

	List<Khoahoc> getKhoaHocs();

	Khoahoc findKhoaHoc(int maKhoaHoc);

	Monhoc findMonHoc(int maMonHoc);

	void upDatePhanCong(Giaovien giaovien);

	void upDateKhoaHoc(Khoahoc khoahoc);

	int countGiaoVien();

	List<Giaovien> getGVCN();

	void updateGiangDay(Giangday giangday);

}
