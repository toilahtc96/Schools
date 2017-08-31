package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vn.com.imic.dao.DaoClass;
import vn.com.imic.model.Hocky;

@Service("hockyService")
public class HockyServicesIplm implements ServicesInterface<Hocky>{

	@Autowired
	private DaoClass<Hocky> hockyDao;
	
	@Override
	public List<Hocky> getAllObjects() {
		return hockyDao.findAll();
	}

	@Override
	public Hocky getObjectById(int id) {
		return hockyDao.findObjectById(id);
	}

	@Override
	public void deleteObject(Hocky e) {
		
	}

	@Override
	public void saveOrUpdateObject(Hocky e) {
		
	}


}
