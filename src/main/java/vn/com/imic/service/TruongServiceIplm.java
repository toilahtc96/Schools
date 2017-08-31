package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vn.com.imic.dao.DaoClass;
import vn.com.imic.model.Truong;

@Service("truongService")
public class TruongServiceIplm implements ServicesInterface<Truong>{

	@Autowired
	private DaoClass<Truong> truongDao;
	
	@Override
	public List<Truong> getAllObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Truong getObjectById(int id) {
		// TODO Auto-generated method stub
		return truongDao.findObjectById(id);
	}

	@Override
	public void deleteObject(Truong e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdateObject(Truong e) {
		// TODO Auto-generated method stub
		
	}

}
