package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Phonghoc;
@Repository
public class PhonghocImpl extends HibernateDaoSupport implements csvcInterface<Phonghoc> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Phonghoc> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Phonghoc.class,"ph");
		return  (List<Phonghoc>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Phonghoc FindById(int id) {
		return hibernateTemplate.get(Phonghoc.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Phonghoc> findByCondition(int iddt) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Phonghoc.class, "ph");
		criteria.createAlias("ph.cosovatchat", "cosovatchat")
				.add(Restrictions.eq("cosovatchat.diemtruong.madiemtruong", iddt));
		List<Phonghoc> lis= (List<Phonghoc>) hibernateTemplate.findByCriteria(criteria);
		return lis;
	}

	@Override
	public void SaveOrUpdate(Phonghoc e) {
		hibernateTemplate.saveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		delete(hibernateTemplate.get(Phonghoc.class, id));
	}

}
