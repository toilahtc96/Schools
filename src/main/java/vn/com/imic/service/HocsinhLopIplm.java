package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.HocsinhDao;
import vn.com.imic.dao.LopDao;
import vn.com.imic.model.Hocsinh;

@Service
@Transactional(readOnly=false)
public class HocsinhLopIplm implements HocsinhLopServices{

	@Autowired
	private HocsinhDao hocsinhDao;
	
	@Autowired
	private LopDao lopDao;
	
	@Override
	public List<Hocsinh> getLimitHocsinhInLop(int lop,int first,int max) {
		return hocsinhDao.findLimitInKhoahoc(lop, first, max);
	}

	@Override
	public int countHocsinhInLop(int lop,int max) {
		return hocsinhDao.CountHocsinhInKhoahoc(lop,max);
	}
	public int countHocsinhInLop(int lop){
		return hocsinhDao.CountHocsinhInKhoahoc(lop);
	}
	public void deleteHocsinhInLop(int lop,int hocsinh){
		hocsinhDao.deleteHocsinhInKhoahoc(lop,hocsinh);
	}
	
	public void addHocsinhInLop(int kh,Hocsinh hs){
		hocsinhDao.SaveOrUpdateHocsinhInLop(kh, hs);
	}
	
	public Hocsinh getHocsinh(String ten,String diachi){
		return hocsinhDao.findHocsinh(ten,diachi);
	}
	
	public List<Hocsinh> getAllHocsinh(){
		return hocsinhDao.findAllHocsinh();
	}
	
	public boolean addHocsinhToLop(int hsid,int id){
		if(!lopDao.addHocsinhInLop(hsid, id))
			return false;
		return true;
	}
}
