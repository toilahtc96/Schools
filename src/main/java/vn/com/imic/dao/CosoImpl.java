package vn.com.imic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.com.imic.model.Cosovatchat;

@Repository
public class CosoImpl extends HibernateDaoSupport implements csvcInterface<Cosovatchat> {

	@Override
	public List<Cosovatchat> findAll() {
		return null;
	}

	@Override
	public Cosovatchat FindById(int id) {
		return (Cosovatchat) hibernateTemplate.get(Cosovatchat.class, id);
	}

	@Override
	public List<Cosovatchat> findByCondition(int iddt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SaveOrUpdate(Cosovatchat e) {
		hibernateTemplate.saveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		// TODO Auto-generated method stub

	}

}
