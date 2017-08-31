package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;


import vn.com.imic.model.Monhoc;

@Repository(value="monhoc")
public class MonhocDaoIplm extends HibernateDaoSupport implements DaoClass<Monhoc>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Monhoc> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Monhoc.class);
		return (List<Monhoc>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Monhoc findObjectById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Monhoc.class, id);
	}

	@Override
	public Monhoc findByCondition(String... condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(Monhoc e) {
		delete(e);
	}

	@Override
	public void SaveOrUpdate(Monhoc e) {
		save(e);
	}

}
