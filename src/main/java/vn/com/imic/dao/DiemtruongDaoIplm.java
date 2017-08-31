package vn.com.imic.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Diemtruong;

@Transactional
@Repository("diemtruongDao")
public class DiemtruongDaoIplm extends HibernateDaoSupport implements DaoClass<Diemtruong>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Diemtruong> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Diemtruong.class);
		return (List<Diemtruong>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Diemtruong findObjectById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Diemtruong.class, id);
	}

	public Diemtruong findByCondition(String... condition){
		return null;
	}

	@Override
	public void Delete(Diemtruong e) {
		delete(e);
		
	}

	@Override
	public void SaveOrUpdate(Diemtruong e) {
		save(e);
		
	}
}
