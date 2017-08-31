package vn.com.imic.dao;

import java.io.ByteArrayOutputStream;
import java.util.List;

import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;

public interface LopDao {
	public List<Lop> findAll();
	public List<Lop> findLimit(int first,int max);
	public Lop findById(int id);
	public void insertOrUpdate(Lop lop);
	public void DeleteLop(int id);
	public int CountLop();
	public Lop findLopByCondition(String tenlop,String diemtruong);
	public List<Khoahoc> findLimitLopInKhoahocById(int first, int max,int namhoc,int hocky,int diemtruong);
	public List<Khoahoc> findLopChange(int id);
	
	public List<Khoahoc> findAllKhoahoc();
	public List<Khoahoc> findAllLopInKhoahoc(String namhoc,String hocki,String diemtruong);
	public List<Khoahoc> findLimitLopInKhoahoc(int first,int max,String namhoc,String hocki,String diemtruong);
	public Khoahoc findByIdLopInKhoahoc(int id);
	public void insertOrUpdateLopInKhoahoc(Khoahoc khoahoc);
	public void DeleteLopInKhoahoc(int id);
	public int CountLopInKhoahoc(String namhoc,String hocki,String diemtruong);
	public int CountLopInKhoahocById(int namhoc,int hocki,int diemtruong);
	public int Page(String namhoc,String hocki,String diemtruong,int max);
	public int PageById(int namhoc,int hocki,int diemtruong,int max);
	
	public ByteArrayOutputStream download();
	public void importFile(String path);
	public void changeLopById(int id,int hsid,int change);
	public boolean addHocsinhInLop(int hsid,int id);
}
