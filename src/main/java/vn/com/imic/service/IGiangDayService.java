package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Giangday;
import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;
import vn.com.imic.model.Monhoc;

public interface IGiangDayService {

	List<Giaovien> getGiaoVienLimit(int first, int max);

	List<Monhoc> getMonHoc();

	List<Giangday> getAll(int maNamHoc);

	void saveOrUpdate(Giangday giangday);

	void delete(int magiangday);

	Giangday findByID(int magiangday);

	// Lấy Danh Sách Giáo Viên, kèm theo danh sách giảng dạy trong 1 năm học.
	Giaovien getGiaoVien(int maGiaoVien, int maNamHoc);

	List<Lop> getLops();

	List<Monhoc> getMonHocs();

	// lấy danh sách khóa học trong namhoc
	List<Khoahoc> getKhoaHocs(int maNamHoc);

	void updatePhanCong(Giaovien giaovien2);

	Khoahoc findKhoaHoc(int maKhoaHoc);

	Monhoc findMonHoc(int maMonHoc);
	List<Giaovien> getGVCN();

	void updateKhoaHoc(Khoahoc khoahoc);

	boolean checkPhanCong(List<Giangday> listGiangDay, Giangday giangday);

	int countGiaoVien();
}
