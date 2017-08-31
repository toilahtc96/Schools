package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Khoahoc;
@Repository
public class KhoahocDAO extends HibernateDaoSupport implements IKhoahocDAO {

	@Override
	public List<Khoahoc> getAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Khoahoc.class);
		return (List<Khoahoc>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public void saveOrUpdate(Khoahoc khoahoc) {
		save(khoahoc);
	}

	@Override
	public void delete(int makhoahoc) {
		Khoahoc khoahoc = findByID(makhoahoc);
		delete(khoahoc);
	}

	@Override
	public Khoahoc findByID(int makhoahoc) {
		return hibernateTemplate.get(Khoahoc.class, makhoahoc);
	}

}
