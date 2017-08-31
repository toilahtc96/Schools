package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Hocsinh;

public interface HocsinhLopServices {
	public List<Hocsinh> getLimitHocsinhInLop(int lop,int first,int max);
	public int countHocsinhInLop(int lop,int max);
	public int countHocsinhInLop(int lop);
	public void deleteHocsinhInLop(int lop,int hocsinh);
	public void addHocsinhInLop(int kh,Hocsinh hs);
	public Hocsinh getHocsinh(String ten,String diachi);
	public List<Hocsinh> getAllHocsinh();
	public boolean addHocsinhToLop(int hsid,int id);
}
