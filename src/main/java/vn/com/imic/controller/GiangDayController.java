package vn.com.imic.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.imic.model.Giangday;
import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Monhoc;
import vn.com.imic.service.IGiangDayService;

@Controller
public class GiangDayController {
	@Autowired
	private IGiangDayService giangDayService;

	@ModelAttribute("monHocs")
	public List<Monhoc> getAllMonHoc() {
		List<Monhoc> listMonHoc = giangDayService.getMonHocs();
		return listMonHoc;
	}

	@ModelAttribute("khoaHocs")
	public List<Khoahoc> getAllKhoaHoc(HttpSession session) {
		System.out.println("Run khoaHocModelAtrribute:");
		Integer manamhoc = (Integer) session.getAttribute("manamhoc");
		if (manamhoc == null) {
			manamhoc = 1;
		}
		session.setAttribute("manamhoc", manamhoc);
		List<Khoahoc> khoaHocs = giangDayService.getKhoaHocs(manamhoc);
		// for (Khoahoc khoahoc : khoaHocs) {
		// System.out.println("KhoaHoc Du Dieu Kien: " +
		// khoahoc.getMakhoahoc());
		// }
		return khoaHocs;
	}

	@RequestMapping(value = "/phancong", method = RequestMethod.GET)
	public String xemDanhSachGiangDay(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			Model model, HttpSession session) {
		Integer record = (Integer) session.getAttribute("record");
		if (record == null) {
			record = 5;
		}
		int totalRecord = giangDayService.countGiaoVien();
		int totalPage = 0;
		if (totalRecord % record == 0) {
			totalPage = totalRecord / record;
		} else {
			totalPage = (totalRecord / record) + 1;
		}
		int first = (page - 1) * record;
		List<Giaovien> giaoViens = giangDayService.getGiaoVienLimit(first, record);
		// System.out.println("ListGiaoVien: " + giaoViens.size());
		List<Monhoc> monHocs = giangDayService.getMonHoc();
		// System.out.println("ListMonHoc: " + monHocs.size());
		model.addAttribute("giaoViens", giaoViens);
		model.addAttribute("monHocs", monHocs);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("record", record);
		model.addAttribute("totalRecord", totalRecord);
		return "giangday/phancong";

	}

	@RequestMapping(value = "/pagesize", method = RequestMethod.GET)
	public String selectRecord(@RequestParam("record") int record, HttpSession session) {
		session.setAttribute("record", record);
		return "redirect:/phancong";
	}

	@RequestMapping(value = "/phancong/confirmUpdate", method = RequestMethod.POST)
	public String conFirmupdate(@ModelAttribute("giaoVien") Giaovien giaoVien, RedirectAttributes redirectAttributes,
			Model model, HttpSession session) {
		Integer manamhoc = (Integer) session.getAttribute("manamhoc");
		// i là biến dùng để đánh số thứ tự lỗi
		int i = 1;
		// Map chứa các erro hiển thị về cho client
		Map<Integer, String> erros = new HashMap<>();

		int maKhoaHoc = giaoVien.getKhoahoc().get(0).getMakhoahoc();

		Khoahoc khoahoc = giangDayService.findKhoaHoc(maKhoaHoc);
		// thực hiện kiểm tra lớp học đã được chủ nhiệm bởi một giáo viên nào đó
		if (khoahoc != null) {
			Giaovien giaoVienChuNhiem = khoahoc.getChunhiem();
			if (giaoVienChuNhiem != null && giaoVien.getMagiaovien() != giaoVienChuNhiem.getMagiaovien()) {
				erros.put(i, "Lớp " + khoahoc.getLop().getTenlop() + " đã được phân công cho giáo viên "
						+ giaoVienChuNhiem.getTen() + " chủ nhiệm");
			}
		}
		if (giaoVien.getGiangday() != null) {

			List<Giangday> listGiangDay = giaoVien.getGiangday();

			Iterator<Giangday> iteratorListGiangDay = listGiangDay.iterator();

			// xóa bỏ những giảng dạy đã xóa khi người dùng tương tác trên giao
			// diện ( giảng dạy bị xóa thì sẽ = null)
			while (iteratorListGiangDay.hasNext()) {
				Giangday giangday = iteratorListGiangDay.next();
				if (giangday.getKhoahoc() == null) {
					iteratorListGiangDay.remove();
				}
			}

			// loại bỏ danh sách giảng dạy bì trùng do người dùng nhập trên giao
			// diện bằng cách cho vào Set
			Set<Giangday> giangdayTmp = new HashSet<>();
			for (Giangday giangday : listGiangDay) {
				giangdayTmp.add(giangday);
			}
			// lấy các phần tử trong set cho vào một list rồi thiết lập lại danh
			// sách giảng dạy cho giáo viên
			List<Giangday> giangdayArraysList = new ArrayList<>();
			giangdayArraysList.addAll(giangdayTmp);
			giaoVien.setGiangday(giangdayArraysList);

			// lấy ra danh sách giảng dạy trong csdl rồi kiểm tra xem giảng dạy
			// mà người dùng nhập có bị trùng hay không
			List<Giangday> giangdays = giangDayService.getAll(manamhoc);
			for (Giangday giangday : giangdays) {
				// kiểm tra trùng giảng dạy
				if (giangDayService.checkPhanCong(listGiangDay, giangday) == true) {
					Giaovien giaovienGiangDay = giangday.getGiaovien();
					if (giangday.getGiaovien().getMagiaovien() != giaoVien.getMagiaovien()) {
						i++;
						erros.put(i, "Môn " + giangday.getMonhoc().getTenmonhoc() + " đã được phân công cho giáo viên "
								+ giangday.getGiaovien().getTen());
					}
				}
			}
		}
		// nếu có lỗi quay về giao diện update giảng dạy
		if (!erros.isEmpty()) {
			Giaovien giaovien2 = giangDayService.getGiaoVien(giaoVien.getMagiaovien(), 1);
			giaoVien.setTen(giaovien2.getTen());
			List<Giangday> giangdays = new ArrayList<>();
			if (giaoVien.getGiangday() != null) {
				for (Giangday giangday : giaoVien.getGiangday()) {
					Khoahoc khoahoc2 = giangDayService.findKhoaHoc(giangday.getKhoahoc().getMakhoahoc());
					Monhoc monhoc = giangDayService.findMonHoc(giangday.getMonhoc().getMamonhoc());
					giangday.setKhoahoc(khoahoc2);
					giangday.setMonhoc(monhoc);
					giangday.setGiaovien(giaoVien);
					giangdays.add(giangday);
				}
			}
			giaoVien.setGiangday(giangdays);
			model.addAttribute("giaoVien", giaoVien);
			model.addAttribute("erros", erros);
			return "giangday/phancong_update";
		}
		// không có lỗi thực hiện update
		giangDayService.updatePhanCong(giaoVien);
		return "redirect:/phancong";
	}

	@RequestMapping(value = "/phancong/{maGiaoVien}/update", method = RequestMethod.GET)
	public String updatePhanCong(@PathVariable("maGiaoVien") int maGiaoVien, Model model, HttpSession session) {
		Integer manamhoc = (Integer) session.getAttribute("manamhoc");
		System.out.println("Begin UpdatePhanCong: " + manamhoc);
		Giaovien giaovien = giangDayService.getGiaoVien(maGiaoVien, manamhoc);
		// System.out.println("GiaoVien: " + giaovien.getMagiaovien() + " - " +
		// giaovien.getTen());
		List<Giangday> giangdays = giaovien.getGiangday();
		// System.out.println("Size GiaoVien Day Nam 1: " + giangdays.size());
		// System.out.println("Danh Sach Giang Day Nam 1: ");
		// for (Giangday giangday : giangdays) {
		// System.out.println("KhoaHoc: " + giangday.getKhoahoc().getMakhoahoc()
		// + "- LopHoc: "
		// + giangday.getKhoahoc().getLop().getTenlop() + "- MonHoc: " +
		// giangday.getMonhoc().getTenmonhoc());
		// }
		// for (Khoahoc khoahoc : giaovien.getKhoahoc()) {
		// System.out.println("Khoa Hoc Chu Nhiem: " + khoahoc.getMakhoahoc());
		// }
		model.addAttribute("giaoVien", giaovien);
		return "giangday/phancong_update";
	}

	@RequestMapping(value = "/phancong/dowload", method = RequestMethod.GET)
	public String dowload(Model model) {
		List<Giaovien> giaoViens = giangDayService.getGiaoVienLimit(0, 13);
		model.addAttribute("giaoViens", giaoViens);
		return "excelView";
	}
}
