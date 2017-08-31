package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Phonghoc;
import vn.com.imic.model.Thietbi;

@Repository
public class ThietBiImpl extends HibernateDaoSupport implements csvcInterface<Thietbi> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Thietbi> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Phonghoc.class);
		return (List<Thietbi>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Thietbi FindById(int id) {
		return hibernateTemplate.get(Thietbi.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Thietbi> findByCondition(int iddt) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Thietbi.class, "tb");
		criteria.createAlias("tb.cosovatchat", "cosovatchat")
				.add(Restrictions.eq("cosovatchat.diemtruong.madiemtruong", iddt));
		return (List<Thietbi>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public void SaveOrUpdate(Thietbi e) {
		hibernateTemplate.saveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		delete(hibernateTemplate.get(Thietbi.class, id));
	}

}
