package vn.com.imic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import vn.com.imic.model.Truong;

@Repository("TruongDao")
public class TruongDaoIplm extends HibernateDaoSupport implements DaoClass<Truong>{

	@Override
	public List<Truong> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Truong findObjectById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Truong.class, id);
	}

	@Override
	public Truong findByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(Truong e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SaveOrUpdate(Truong e) {
		// TODO Auto-generated method stub
		
	}

}
