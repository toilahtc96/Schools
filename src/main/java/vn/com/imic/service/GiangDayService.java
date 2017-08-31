package vn.com.imic.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.IGiangDayDAO;
import vn.com.imic.model.Giangday;
import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;
import vn.com.imic.model.Monhoc;

@Service
@Transactional
public class GiangDayService implements IGiangDayService {
	@Autowired
	private IGiangDayDAO giangdayDAO;

	@Override
	public List<Giangday> getAll(int maNamHoc) {
		List<Giangday> listGiangDay = giangdayDAO.getAll();
		Iterator<Giangday> iterator = listGiangDay.iterator();
		while (iterator.hasNext()) {
			Giangday giangday = iterator.next();
			if (giangday.getKhoahoc().getNamhoc().getManamhoc() != maNamHoc) {
				iterator.remove();
			}
		}
		return listGiangDay;
	}

	@Override
	public void saveOrUpdate(Giangday giangDay) {
		giangdayDAO.saveOrUpdate(giangDay);
	}

	@Override
	public void delete(int maGiangDay) {
		giangdayDAO.delete(maGiangDay);
	}

	@Override
	public Giangday findByID(int maGiangDay) {
		return giangdayDAO.findByID(maGiangDay);
	}

	@Override
	public List<Giaovien> getGiaoVienLimit(int first, int max) {
		return giangdayDAO.getGiaoVien(first, max);
	}

	@Override
	public List<Monhoc> getMonHoc() {
		return giangdayDAO.getMonHoc();
	}

	@Override
	public Giaovien getGiaoVien(int maGiaoVien, int maNamHoc) {
		Giaovien giaovien = giangdayDAO.getGiaoVien(maGiaoVien);

		List<Giangday> listGiangDay = giaovien.getGiangday();
		List<Khoahoc> listKhoaHoc = giaovien.getKhoahoc();

		Iterator<Giangday> giangDays = listGiangDay.iterator();
		Iterator<Khoahoc> khoaHocs = listKhoaHoc.iterator();

		while (khoaHocs.hasNext()) {
			Khoahoc khoahoc = khoaHocs.next();
			if (khoahoc.getNamhoc().getManamhoc() != maNamHoc) {
				// System.out.println("Lop Khoa Hoc Chu Nhiem Khong Phu Hop: " +
				// khoahoc.getMakhoahoc());
				khoaHocs.remove();
			}
		}
		while (giangDays.hasNext()) {
			Giangday giangday = giangDays.next();
			if (giangday.getKhoahoc().getNamhoc().getManamhoc() != maNamHoc) {
				// System.out.println("KhoaHocService Khong Phu Hop: " +
				// giangday.getKhoahoc().getMakhoahoc());
				giangDays.remove();
			}
		}
		return giaovien;
	}

	@Override
	public List<Lop> getLops() {
		return giangdayDAO.getLop();
	}

	@Override
	public List<Monhoc> getMonHocs() {
		return giangdayDAO.getMonHocs();
	}

	@Override
	public List<Khoahoc> getKhoaHocs(int maNamHoc) {
		List<Khoahoc> khoahocs = giangdayDAO.getKhoaHocs();
		Iterator<Khoahoc> iterator = khoahocs.iterator();
		while (iterator.hasNext()) {
			Khoahoc khoahoc = iterator.next();
			if (khoahoc.getNamhoc().getManamhoc() != maNamHoc) {
				// System.out.println("Khoa Hoc Khong du Dieu Kien: " +
				// khoahoc.getMakhoahoc());
				iterator.remove();
			}
		}
		return khoahocs;
	}

	@Override
	public void updatePhanCong(Giaovien giaoVien) {
		Giaovien giaovien2 = getGiaoVien(giaoVien.getMagiaovien(), 1);
		Khoahoc khoahoc = findKhoaHoc(giaoVien.getKhoahoc().get(0).getMakhoahoc());

		if (giaovien2.getKhoahoc().size() > 0) {
			Khoahoc existedKhoaHoc = giaovien2.getKhoahoc().get(0);
			existedKhoaHoc.setChunhiem(null);
			giangdayDAO.upDateKhoaHoc(existedKhoaHoc);
		}

		if (khoahoc != null) {
			khoahoc.setChunhiem(giaovien2);
			giangdayDAO.upDateKhoaHoc(khoahoc);
		}

		if (giaovien2.getGiangday().size() > 0) {
			for (Giangday giangday : giaovien2.getGiangday()) {
				giangdayDAO.delete(giangday.getMagiangday());
			}
		}
		// System.out.println("Chay Den Day: " + giaoVien.getGiangday());
		if (giaoVien.getGiangday() != null) {
			for (Giangday giangday : giaoVien.getGiangday()) {
				Khoahoc khoahoc2 = findKhoaHoc(giangday.getKhoahoc().getMakhoahoc());
				Monhoc monhoc = findMonHoc(giangday.getMonhoc().getMamonhoc());
				giangday.setKhoahoc(khoahoc2);
				giangday.setMonhoc(monhoc);
				giangday.setGiaovien(giaovien2);
				giangdayDAO.saveOrUpdate(giangday);
			}
			// giaovien2.setGiangday(giangdays);
			// giangdayDAO.upDatePhanCong(giaovien2);
		}
	}

	@Override
	public Khoahoc findKhoaHoc(int maKhoaHoc) {
		Khoahoc khoahoc = giangdayDAO.findKhoaHoc(maKhoaHoc);
		return khoahoc;
	}

	@Override
	public Monhoc findMonHoc(int maMonHoc) {
		return giangdayDAO.findMonHoc(maMonHoc);
	}

	@Override
	public void updateKhoaHoc(Khoahoc khoahoc) {
		giangdayDAO.upDateKhoaHoc(khoahoc);
	}

	@Override
	public boolean checkPhanCong(List<Giangday> listGiangDay, Giangday giangday) {
		for (int i = 0; i < listGiangDay.size(); i++) {
			if (giangday.getMonhoc().getMamonhoc() == listGiangDay.get(i).getMonhoc().getMamonhoc()
					&& giangday.getKhoahoc().getMakhoahoc() == listGiangDay.get(i).getKhoahoc().getMakhoahoc()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int countGiaoVien() {
		return giangdayDAO.countGiaoVien();
	}

	@Override
	public List<Giaovien> getGVCN() {
		return giangdayDAO.getGVCN();
	}
}
