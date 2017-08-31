package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Banghe;
@Repository
public class BangheImpl extends HibernateDaoSupport implements csvcInterface<Banghe> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Banghe> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Banghe.class);
		return (List<Banghe>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Banghe FindById(int id) {
		return hibernateTemplate.get(Banghe.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Banghe> findByCondition(int iddt) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Banghe.class, "bg");
		criteria.createAlias("bg.cosovatchat", "cosovatchat")
				.add(Restrictions.eq("cosovatchat.diemtruong.madiemtruong", iddt));
		List<Banghe> lis = (List<Banghe>) hibernateTemplate.findByCriteria(criteria);
		return lis;
	}

	@Override
	public void SaveOrUpdate(Banghe e) {
		hibernateTemplate.saveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		delete(hibernateTemplate.get(Banghe.class, id));
	}

}
