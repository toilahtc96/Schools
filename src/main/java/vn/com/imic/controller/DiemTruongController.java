package vn.com.imic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.imic.model.Diemtruong;
import vn.com.imic.model.Monhoc;
import vn.com.imic.model.Namhoc;
import vn.com.imic.model.Truong;
import vn.com.imic.service.NamhocServices;
import vn.com.imic.service.ServicesInterface;

@Controller
public class DiemTruongController {
	
	@Autowired(required=true)
	private ServicesInterface<Diemtruong> diemtruongService;
	
	@Autowired
	private ServicesInterface<Truong> truongService;
	
	@Autowired
	private NamhocServices namhocService;
	
	@Autowired
	private ServicesInterface<Monhoc> monhocServices;
	
	@RequestMapping(value="/diemtruong",method = RequestMethod.GET)
	public ModelAndView viewDiemtruong(){
		ModelAndView model = new ModelAndView("diemtruong/diemtruong");
		model.addObject("diemtruongs",diemtruongService.getAllObjects());
		model.addObject("namhocs",namhocService.getAllNamhoc());
		model.addObject("monhocs",monhocServices.getAllObjects());
		model.addObject("lisnh",new ArrayList<>());
		model.addObject("lisdt",new ArrayList<>());
		model.addObject("lismh",new ArrayList<>());
		return model;
	}
	
	@RequestMapping(value="/diemtruong/updatedt",method = RequestMethod.POST)
	public String getLis(Model model,@ModelAttribute("listen") List<String> listen,
			@ModelAttribute("lisemail") List<String> lisemail,
			@ModelAttribute("lissdt") List<String> lissdt,
			BindingResult result,RedirectAttributes redirect){
		
		Truong tr = truongService.getObjectById(1);
		List<Diemtruong> lis = diemtruongService.getAllObjects();
		Diemtruong dt = new Diemtruong();
		int j=0;
		
		for(int i=0;i<lis.size();i++){
			for(j=0;j<listen.size();j++){
				if(lis.get(i).getTendiemtruong().equals(listen.get(j))){
					break;
				}
			}
			if(j == listen.size()){
				diemtruongService.deleteObject(lis.get(i));
				lis.remove(i);
			}
		}
		
		int k=lis.size();
		for(int i=0;i<listen.size();i++){
			for(j=0;j<k;j++){
				if(lis.get(j).getTendiemtruong().equals(listen.get(i))){
					lis.get(j).setEmail(lisemail.get(i));
					lis.get(j).setSdt(lissdt.get(i));
					break;
				}
			}
			if(j==k){
				dt = new Diemtruong();
				dt.setTendiemtruong(listen.get(i));
				dt.setEmail(lisemail.get(i));
				dt.setSdt(lissdt.get(i));
				dt.setDiachi("xxx");
				dt.setTruong(tr);
				lis.add(dt);
			}
		}

		
		for(int i=0;i<lis.size();i++){
			diemtruongService.saveOrUpdateObject(lis.get(i));
		}
		
		
		return "redirect:/diemtruong";
	}
	
	
	@RequestMapping(value="/diemtruong/updatenh",method = RequestMethod.POST)
	public String getLisNh(Model model,@ModelAttribute("lisnh") List<String> lisnh,
			BindingResult result,RedirectAttributes redirect){
		
		for(int i=0;i<lisnh.size();i++){
			Namhoc nh = new Namhoc();
			nh.setThoigian(lisnh.get(i));
			namhocService.saveNamhoc(nh);
		}
		
		return "redirect:/diemtruong";
	}
	
	@RequestMapping(value="/diemtruong/updatemh",method = RequestMethod.POST)
	public String getLisMh(Model model,@ModelAttribute("lismh") List<String> lismh,
			BindingResult result,RedirectAttributes redirect){
		
		for(int i=0;i<lismh.size();i++){
			Monhoc mh = new Monhoc();;
			mh.setTenmonhoc(lismh.get(i));
			monhocServices.saveOrUpdateObject(mh);
		}
		
		return "redirect:/diemtruong";
	}
	
}
