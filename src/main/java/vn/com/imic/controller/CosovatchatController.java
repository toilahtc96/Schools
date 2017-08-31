package vn.com.imic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.com.imic.model.Banghe;
import vn.com.imic.model.Cosovatchat;
import vn.com.imic.model.Diemtruong;
import vn.com.imic.model.Khuonvien;
import vn.com.imic.model.Khuonvienform;
import vn.com.imic.model.NhaXe;
import vn.com.imic.model.Nhavesinh;
import vn.com.imic.model.Nhavesinhform;
import vn.com.imic.model.NhaxeTG;
import vn.com.imic.model.Phonghoc;
import vn.com.imic.model.Thietbi;
import vn.com.imic.model.Thietbiform;
import vn.com.imic.model.bangheform;
import vn.com.imic.model.phonghocform;
import vn.com.imic.service.CosovatchatService;
import vn.com.imic.service.ServicesInterface;

@Controller
@Scope(scopeName = "session")
public class CosovatchatController {

	@Autowired
	@Qualifier("diemtruongServices")
	private ServicesInterface<Diemtruong> diemtruongser;

	@Autowired
	@Qualifier("csservice")
	private CosovatchatService<Cosovatchat> csvcser;

	@Autowired
	@Qualifier("bangheS")
	private CosovatchatService<Banghe> bangheservice;

	@Autowired
	@Qualifier("khuonvienS")
	private CosovatchatService<Khuonvien> khuonvienser;

	@Autowired
	@Qualifier("nhavesinhS")
	private CosovatchatService<Nhavesinh> nvsser;

	@Autowired
	@Qualifier("nhaxeS")
	private CosovatchatService<NhaXe> nxeser;

	@Autowired
	@Qualifier("thietbiS")
	private CosovatchatService<Thietbi> thietbiser;

	@Autowired
	@Qualifier("phonghocS")
	private CosovatchatService<Phonghoc> phonghocser;

	@RequestMapping(value = "cosovatchat/nhaxe", method = RequestMethod.GET)
	public ModelAndView getnxById() {
		ModelAndView model = new ModelAndView("cosovatchat/nhaxe");
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		List<NhaXe> nhaxes = new ArrayList<>();
		NhaxeTG nhaxeTG = new NhaxeTG();
		for (Diemtruong diemtruong : diemtruongs) {
			Cosovatchat cs = diemtruong.getCosovatchat();
			if (cs == null) {
				cs = new Cosovatchat();
				cs.setMacosovatchat(diemtruong.getMadiemtruong());
				cs.setDiemtruong(diemtruong);
				diemtruong.setCosovatchat(cs);
				csvcser.SaveOrUpdate(cs);
				diemtruongser.saveOrUpdateObject(diemtruong);
			}
			if (cs.getNhaXe() == null) {
				NhaXe nxn = new NhaXe(0, 0, 0, 0);
				nxn.setCosovatchat(cs);
				nxn.setMaNhaxe(cs.getMacosovatchat());
				nxeser.SaveOrUpdate(nxn);
				cs.setNhaXe(nxn);
				csvcser.SaveOrUpdate(cs);
				String error = "Chưa Có Thông Tin... Ấn F5 Để cập nhật thông tin";
				model.addObject("EMPTY", error);

			} else {

				NhaXe nhaxe = (NhaXe) nxeser.FindById(diemtruong.getCosovatchat().getNhaXe().getMaNhaxe());
				nhaxes.add(nhaxe);
			}
		}
		model.addObject("nhaxes", nhaxes);
		model.addObject("nhaxetemp", nhaxeTG);
		return model;

	}

	@RequestMapping(value = "cosovatchat/banghe", method = RequestMethod.GET)
	public ModelAndView getbgById() {
		ModelAndView model = new ModelAndView("cosovatchat/banghe");
		bangheform bangheform = new bangheform();
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		List<Banghe> banghes = new ArrayList<>();
		for (Diemtruong diemtruong : diemtruongs) {
			Cosovatchat cs = diemtruong.getCosovatchat();
			if (cs == null) {
				cs = new Cosovatchat();
				cs.setMacosovatchat(diemtruong.getMadiemtruong());
				cs.setDiemtruong(diemtruong);
				diemtruong.setCosovatchat(cs);
				csvcser.SaveOrUpdate(cs);
				diemtruongser.saveOrUpdateObject(diemtruong);
			}
			if (cs.getBanghe() == null) {
				Banghe bgn = new Banghe(0, 0, 0, 0);
				bgn.setCosovatchat(cs);
				bgn.setMaBanGhe(cs.getMacosovatchat());
				bangheservice.SaveOrUpdate(bgn);
				cs.setBanghe(bgn);
				csvcser.SaveOrUpdate(cs);
				String error = "Chưa Có Thông Tin... Ấn F5 Để cập nhật thông tin";
				model.addObject("EMPTY", error);
			} else {
				Banghe bg = (Banghe) bangheservice.FindById(diemtruong.getMadiemtruong());
				banghes.add(bg);
			}
		}
		model.addObject("banghetemp", bangheform);
		model.addObject("banghes", banghes);
		return model;
	}

	@RequestMapping(value = "cosovatchat/nhavesinh", method = RequestMethod.GET)
	public ModelAndView getnvsById() {
		ModelAndView model = new ModelAndView("cosovatchat/nhavesinh");
		Nhavesinhform nhavesinhform = new Nhavesinhform();
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		List<Nhavesinh> nhavss = new ArrayList<>();
		for (Diemtruong diemtruong : diemtruongs) {
			Cosovatchat cs = diemtruong.getCosovatchat();
			if (cs == null) {
				cs = new Cosovatchat();
				cs.setMacosovatchat(diemtruong.getMadiemtruong());
				cs.setDiemtruong(diemtruong);
				diemtruong.setCosovatchat(cs);
				csvcser.SaveOrUpdate(cs);
				diemtruongser.saveOrUpdateObject(diemtruong);
			}
			if (cs.getNhavesinh() == null) {
				Nhavesinh nvsn = new Nhavesinh(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
				nvsn.setCosovatchat(cs);
				nvsn.setMaNvs(cs.getMacosovatchat());
				nvsser.SaveOrUpdate(nvsn);
				cs.setNhavesinh(nvsn);
				csvcser.SaveOrUpdate(cs);
				String error = "Chưa Có Thôngn Tin... Ấn F5 Để cập nhật thông tin";
				model.addObject("EMPTY", error);
			} else {
				Nhavesinh nvs = (Nhavesinh) nvsser.FindById(diemtruong.getCosovatchat().getMacosovatchat());
				nhavss.add(nvs);
			}
		}
		model.addObject("nhavesinhtemp", nhavesinhform);
		model.addObject("nhavss", nhavss);
		return model;
	}

	@RequestMapping(value = "cosovatchat/phonghoc", method = RequestMethod.GET)
	public ModelAndView getphonghocById() {
		ModelAndView model = new ModelAndView("cosovatchat/phonghoc");
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		phonghocform phonghocform = new phonghocform();
		List<Phonghoc> phonghocs = new ArrayList<>();
		for (Diemtruong diemtruong : diemtruongs) {
			Cosovatchat cs = diemtruong.getCosovatchat();
			if (cs == null) {
				cs = new Cosovatchat();
				cs.setMacosovatchat(diemtruong.getMadiemtruong());
				cs.setDiemtruong(diemtruong);
				diemtruong.setCosovatchat(cs);
				csvcser.SaveOrUpdate(cs);
				diemtruongser.saveOrUpdateObject(diemtruong);
			}
			if (cs.getPhongHoc() == null) {
				Phonghoc phn = new Phonghoc(0, "", 0, false);
				phn.setMaP(cs.getMacosovatchat());
				phn.setCosovatchat(cs);
				phonghocser.SaveOrUpdate(phn);
				cs.setPhongHoc(phn);
				csvcser.SaveOrUpdate(cs);
				String error = "Chưa Có Thông Tin... Ấn F5 Để cập nhật thông tin";
				model.addObject("EMPTY", error);

			} else {

				Phonghoc ph = phonghocser.FindById(diemtruong.getMadiemtruong());
				phonghocs.add(ph);
			}
		}
		model.addObject("phonghoctemp", phonghocform);
		model.addObject("phonghocs", phonghocs);
		return model;
	}

	@RequestMapping(value = "cosovatchat/khuonvien", method = RequestMethod.GET)
	public ModelAndView getkvById() {
		ModelAndView model = new ModelAndView("cosovatchat/khuonvien");
		Khuonvienform khuonvienform = new Khuonvienform();
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		List<Double> lissum = new ArrayList<>();
		List<Khuonvien> khuonviens = new ArrayList<>();
		for (Diemtruong diemtruong : diemtruongs) {
			Cosovatchat cs = diemtruong.getCosovatchat();
			if (cs == null) {
				cs = new Cosovatchat();
				cs.setMacosovatchat(diemtruong.getMadiemtruong());
				cs.setDiemtruong(diemtruong);
				diemtruong.setCosovatchat(cs);
				csvcser.SaveOrUpdate(cs);
				diemtruongser.saveOrUpdateObject(diemtruong);
			}
			if (cs.getKhuonvien() == null) {
				Khuonvien kvi = new Khuonvien(0, 0, 0, 0, 0, false);
				kvi.setCosovatchat(cs);
				kvi.setMakhuonvien(cs.getMacosovatchat());
				khuonvienser.SaveOrUpdate(kvi);
				cs.setKhuonvien(kvi);
				csvcser.SaveOrUpdate(cs);
				String error = "Chưa Có Thông Tin... Ấn F5 Để cập nhật thông tin";
				model.addObject("EMPTY", error);
			} else {
				Khuonvien kv = khuonvienser.FindById(diemtruong.getMadiemtruong());
				double sum = kv.getDithue() + kv.getDuoccap() + kv.getSanchoi() + kv.getSantap();
				lissum.add(sum);
				khuonviens.add(kv);
			}

		}
		model.addObject("listsum", lissum);
		model.addObject("khuonviens", khuonviens);
		model.addObject("khuonvientemp", khuonvienform);
		return model;
	}

	@RequestMapping(value = "cosovatchat/thietbi", method = RequestMethod.GET)
	public ModelAndView gettbById() {
		ModelAndView model = new ModelAndView("cosovatchat/thietbi");
		Thietbiform thietbiform = new Thietbiform();
		List<Diemtruong> diemtruongs = diemtruongser.getAllObjects();
		List<Thietbi> thietbis = new ArrayList<>();
		for (Diemtruong diemtruong : diemtruongs) {
			Cosovatchat cs = diemtruong.getCosovatchat();
			if (cs == null) {
				cs = new Cosovatchat();
				cs.setMacosovatchat(diemtruong.getMadiemtruong());
				cs.setDiemtruong(diemtruong);
				diemtruong.setCosovatchat(cs);
				csvcser.SaveOrUpdate(cs);
				diemtruongser.saveOrUpdateObject(diemtruong);
			}
			if (cs.getThietbi() == null) {
				Thietbi tbn = new Thietbi(0, 0, 0, false);
				tbn.setCosovatchat(cs);
				tbn.setMaTbi(cs.getMacosovatchat());
				thietbiser.SaveOrUpdate(tbn);
				cs.setThietbi(tbn);
				csvcser.SaveOrUpdate(cs);
				String error = "Chưa Có Thông Tin... Ấn F5 Để cập nhật thông tin";
				model.addObject("EMPTY", error);
			} else {
				Thietbi tb = new Thietbi();
				tb = thietbiser.FindById(diemtruong.getMadiemtruong());
				thietbis.add(tb);
			}
		}
		model.addObject("thietbitemp", thietbiform);
		model.addObject("thietbis", thietbis);
		return model;
	}

	@RequestMapping(value = "cosovatchat/nhavesinh", method = RequestMethod.POST)
	public String EditNvs(Model model, @ModelAttribute("nhavesinh") Nhavesinh nhavesinh) {
		Nhavesinh nvs = nvsser.FindById(nhavesinh.getMaNvs());
		nvs.setGvnamchuadatchuan(nhavesinh.getGvnamchuadatchuan());
		nvs.setGvnamdatchuan(nhavesinh.getGvnamdatchuan());
		nvs.setGvnuchuadatchuan(nhavesinh.getGvnuchuadatchuan());
		nvs.setGvnudatchuan(nhavesinh.getGvnudatchuan());
		nvs.setHsnamchuadatchuan(nhavesinh.getHsnamchuadatchuan());
		nvs.setHsnamdatchuan(nhavesinh.getHsnamdatchuan());
		nvs.setHsnuchuadatchuan(nhavesinh.getHsnuchuadatchuan());
		nvs.setHsnudatchuan(nhavesinh.getHsnudatchuan());
		nvs.setSgvnamchuachuan(nhavesinh.getSgvnamchuachuan());
		nvs.setSgvnamchuan(nhavesinh.getSgvnamchuan());
		nvs.setSgvnnuchuan(nhavesinh.getSgvnnuchuan());
		nvs.setSgvnuchuachuan(nhavesinh.getSgvnuchuachuan());
		nvs.setShsnamchuachuan(nhavesinh.getShsnamchuachuan());
		nvs.setShsnamchuan(nhavesinh.getShsnamchuan());
		nvs.setShsnuchuachuan(nhavesinh.getShsnuchuachuan());
		nvs.setShsnuchuan(nhavesinh.getShsnuchuan());
		nvsser.SaveOrUpdate(nvs);
		return "redirect:nhavesinh";

	}

	@RequestMapping(value = "cosovatchat/nhaxe", method = RequestMethod.POST)
	public String EditNxe(Model model, @ModelAttribute("nhaxetemp") NhaxeTG nhaxetg) {
		int id = Integer.parseInt(nhaxetg.getManhaxe());
		NhaXe nxe = nxeser.FindById(id);
		if (nhaxetg.getNhaxegv() == "") {
			nxe.setNhaxegv(0);
		} else {
			nxe.setNhaxegv(Integer.parseInt(nhaxetg.getNhaxegv()));
		}
		if (nhaxetg.getNhaxehs() == "") {
			nxe.setNhaxehs(0);
		} else {
			nxe.setNhaxehs(Integer.parseInt(nhaxetg.getNhaxehs()));
		}
		if (nhaxetg.getSgv() == "") {
			nxe.setSgv(0);
		} else {
			nxe.setSgv(Double.parseDouble(nhaxetg.getSgv()));
		}
		if (nhaxetg.getShs() == "") {
			nxe.setShs(0);
		} else {
			nxe.setShs(Double.parseDouble(nhaxetg.getShs()));
		}
		nxeser.SaveOrUpdate(nxe);
		return "redirect: nhaxe";
	}

	@RequestMapping(value = "cosovatchat/khuonvien", method = RequestMethod.POST)
	public String EditKv(@ModelAttribute("khuonvientemp") Khuonvienform khuonvienform) {
		Khuonvien kv = khuonvienser.FindById(khuonvienform.getMakhuonvien());
		if (khuonvienform.getDieukienngoaitroi().equals("x") == true
				|| khuonvienform.getDieukienngoaitroi().equals("X") == true) {
			kv.setDieukienngoaitroi(true);
		} else
			kv.setDieukienngoaitroi(false);
		kv.setDithue(khuonvienform.getDithue());
		kv.setDuoccap(khuonvienform.getDuoccap());
		kv.setSanchoi(khuonvienform.getSanchoi());
		kv.setSoluonvuon(khuonvienform.getSoluonvuon());
		kv.setSantap(khuonvienform.getSantap());
		khuonvienser.SaveOrUpdate(kv);
		return "redirect: khuonvien";
	}

	@RequestMapping(value = "cosovatchat/phonghoc", method = RequestMethod.POST)
	public String Editph(@ModelAttribute("phonghoctemp") phonghocform phonghocform) {
		Phonghoc ph = phonghocser.FindById(phonghocform.getMaP());
		if (phonghocform.getXaymoi().equals("x") == true || phonghocform.getXaymoi().equals("X") == true) {
			ph.setXaymoi(true);
		} else
			ph.setXaymoi(false);
		ph.setCapdoxd(phonghocform.getCapdoxd());
		ph.setDientich(phonghocform.getDientich());
		ph.setTenPhong(phonghocform.getTenPhong());
		phonghocser.SaveOrUpdate(ph);
		return "redirect: phonghoc";
	}

	@RequestMapping(value = "cosovatchat/banghe", method = RequestMethod.POST)
	public String Editbg(@ModelAttribute("banghetemp") bangheform bangheform) {
		Banghe bg = bangheservice.FindById(bangheform.getMaBanGhe());
		bg.setBanBon(bangheform.getBanBon());
		bg.setBanHai(bangheform.getBanHai());
		bg.setGheBon(bangheform.getGheBon());
		bg.setGheHai(bangheform.getGheHai());
		bangheservice.SaveOrUpdate(bg);
		return "redirect:banghe";
	}

	@RequestMapping(value = "cosovatchat/thietbi", method = RequestMethod.POST)
	public String Edittb(@ModelAttribute("thietbitemp") Thietbiform thietbiform) {
		Thietbi thietbi = thietbiser.FindById(thietbiform.getMaTbi());
		if (thietbiform.getInternet().equals("x") || thietbiform.equals("x")) {
			thietbi.setInternet(true);
		} else
			thietbi.setInternet(false);
		thietbi.setMaygv(thietbiform.getMaygv());
		thietbi.setMayhs(thietbiform.getMayhs());
		thietbi.setMaychieu(thietbiform.getMaychieu());
		thietbiser.SaveOrUpdate(thietbi);
		return "redirect:thietbi";
	}

	@RequestMapping(value = "cosovatchat", method = RequestMethod.GET)
	public String Editcsvc() {
		List<Diemtruong> listdt = diemtruongser.getAllObjects();
		if (listdt.size() == 0) {
			return "redirect:home";
		} else {
			for (Diemtruong diemtruong : listdt) {
				if (diemtruong.getCosovatchat() == null) {
					Cosovatchat vc = new Cosovatchat();
					vc.setMacosovatchat(diemtruong.getMadiemtruong());
					vc.setDiemtruong(diemtruong);
					diemtruong.setCosovatchat(vc);
					csvcser.SaveOrUpdate(vc);

					diemtruongser.saveOrUpdateObject(diemtruong);

				} else {
					return "redirect:cosovatchat/khuonvien";
				}
			}
			return "redirect:cosovatchat/khuonvien";
		}

	}
}
