package vn.com.imic.service;

import java.io.InputStream;
import java.util.List;

import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;

public interface LopServices {
	public List<Khoahoc> getAllLopInKhoahoc(String namhoc,String hocki,String diemtruong);
	public List<Khoahoc> getLimitLopInKhoahoc(String namhoc,String hocki,String diemtruong,int first,int max);
	public void SaveOrUpdateLopInKhoahoc(Lop lop,Khoahoc khoahoc);
	public void DeleteLopInKhoahoc(int makhoahoc);
	public int getPage(String namhoc,String hocki,String diemtruong,int max);
	public int getPageById(int namhoc,int hocki,int diemtruong,int max);
	public Khoahoc getKhoahocById(int id);
	public Lop getLopById(int id);
	public Lop findLop(String tenlop,String diemtruong);
	public List<Khoahoc> getLimitLopInKhoahocById(int namhoc,int hocki,int diemtruong,int first,int max);
	public List<Khoahoc> getAllKhoahoc();
	public List<Khoahoc> getLopChange(int id);
	public void changeLop(int id,int hsid,int change);
	public void importLopFromFile(InputStream fis);
}
