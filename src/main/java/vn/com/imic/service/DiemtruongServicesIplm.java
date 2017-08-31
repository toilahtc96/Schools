package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.DaoClass;
import vn.com.imic.model.Diemtruong;

@Service("diemtruongServices")
public class DiemtruongServicesIplm implements ServicesInterface<Diemtruong>{

	@Autowired
	private DaoClass<Diemtruong> diemtruongDao;
	
	
	@Override
	public List<Diemtruong> getAllObjects() {
		return diemtruongDao.findAll();
	}

	@Override
	public Diemtruong getObjectById(int id) {
		return diemtruongDao.findObjectById(id);
	}

	@Override
	public void deleteObject(Diemtruong e) {
		diemtruongDao.Delete(e);
		
	}

	@Override
	public void saveOrUpdateObject(Diemtruong e) {
		diemtruongDao.SaveOrUpdate(e);
		
	}

}
