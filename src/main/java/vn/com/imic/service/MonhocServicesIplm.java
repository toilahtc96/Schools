package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.DaoClass;
import vn.com.imic.model.Monhoc;

@Service("monhocService")
@Transactional(readOnly=false)
public class MonhocServicesIplm implements ServicesInterface<Monhoc>{

	@Autowired
	private DaoClass<Monhoc> dao;
	
	@Override
	public List<Monhoc> getAllObjects() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Monhoc getObjectById(int id) {
		// TODO Auto-generated method stub
		return dao.findObjectById(id);
	}

	@Override
	public void deleteObject(Monhoc e) {
		// TODO Auto-generated method stub
		dao.Delete(e);
	}

	@Override
	public void saveOrUpdateObject(Monhoc e) {
		// TODO Auto-generated method stub
		dao.SaveOrUpdate(e);
	}

}
