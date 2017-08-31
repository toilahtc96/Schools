package vn.com.imic.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.imic.model.Diemtruong;
import vn.com.imic.model.Hocky;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;
import vn.com.imic.model.LopDataTemp;
import vn.com.imic.model.Namhoc;
import vn.com.imic.service.LopServices;
import vn.com.imic.service.NamhocServices;
import vn.com.imic.service.ServicesInterface;
import vn.com.imic.validator.AddLopValidate;

@Controller
public class AddLopController {


	@Autowired
	private LopServices sevices;
	
	@Autowired
	private NamhocServices namhocServices;
	
	@Autowired
	private ServicesInterface<Hocky> hockiServices;
	
	@Autowired
	private ServicesInterface<Diemtruong> diemtruongServices;
	
	
	@Autowired
	private AddLopValidate lopValidate;

	
	@InitBinder
	protected void InitBinder(WebDataBinder binder){
		binder.setValidator(lopValidate);
		binder.registerCustomEditor(Diemtruong.class,"diemtruong",new PropertyEditorSupport(){ //add object for selected option in jsp file
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Diemtruong diemtruong = diemtruongServices.getObjectById(Integer.parseInt(text));
				setValue(diemtruong);
			}
		});
		
		binder.registerCustomEditor(Namhoc.class,"namhoc", new PropertyEditorSupport(){

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Namhoc namhoc = namhocServices.getNamhocById(Integer.parseInt(text));
				setValue(namhoc);
			}
			
		});
		
		binder.registerCustomEditor(Hocky.class,"hocky", new PropertyEditorSupport(){

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Hocky hocky = hockiServices.getObjectById(Integer.parseInt(text));
				setValue(hocky);
			}
			
		});
	}
	
	@RequestMapping(value="/lop/add",method = RequestMethod.GET)
	public ModelAndView setAddView(){
		ModelAndView model = new ModelAndView("lop/addLop");
		List<Namhoc> nam = new ArrayList<>();
		nam = namhocServices.getAllNamhoc();
		
		List<Hocky> hk = new ArrayList<>();
		hk = hockiServices.getAllObjects();
		
		List<Diemtruong> dt = new ArrayList<>();
		dt = diemtruongServices.getAllObjects();
		
		model.addObject("nam", nam);
		model.addObject("hk", hk);
		model.addObject("dt", dt);
		model.addObject("loptemp", new LopDataTemp());
		return model;
	}
	
	@RequestMapping(value="/lop/addLop",method = RequestMethod.POST) //add object
	public String addLop(Model model,@ModelAttribute("loptemp") @Validated LopDataTemp loptemp,BindingResult result,
			RedirectAttributes redirect){
		System.out.println(loptemp.getTenlop());
//		lopValidate.validate(loptemp, result);
		if(result.hasErrors()){
			for(int i=0;i<result.getErrorCount();i++){
				System.out.println(result.getAllErrors().get(i).getDefaultMessage());
			}
			List<Namhoc> nam = new ArrayList<>();
			nam = namhocServices.getAllNamhoc();
			
			List<Hocky> hk = new ArrayList<>();
			hk = hockiServices.getAllObjects();
			
			List<Diemtruong> dt = new ArrayList<>();
			dt = diemtruongServices.getAllObjects();
			
			model.addAttribute("nam", nam);
			model.addAttribute("hk", hk);
			model.addAttribute("dt", dt);
			//model.addAttribute("loptemp", new LopDataTemp());
			return "lop/addLop";
		}
		
		Khoahoc kh = new Khoahoc();
		kh.setHocky(loptemp.getHocky());
		kh.setNamhoc(loptemp.getNamhoc());
		Lop lop = null;
		//TODO check diem truong == null;
		//check Lop, if Lop already exists , do nothing , else add new Lop
		if(null == sevices.findLop(loptemp.getTenlop(),loptemp.getDiemtruong().getTendiemtruong())){ 
			lop = new Lop();
			lop.setDiemtruong(loptemp.getDiemtruong());
			lop.setSotiethoc(loptemp.getSotiethoc());
			lop.setTenlop(loptemp.getTenlop());
			kh.setLop(lop);
		}
		else {
			lop = sevices.findLop(loptemp.getTenlop(),loptemp.getDiemtruong().getTendiemtruong());
			lop.setSotiethoc(loptemp.getSotiethoc());
			kh.setLop(lop);
		}
		
		sevices.SaveOrUpdateLopInKhoahoc(lop, kh);
		return "redirect:/lop";
	}
	
	

}
