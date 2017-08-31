package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.NhaXe;

@Repository
public class NhaxeImpl extends HibernateDaoSupport implements csvcInterface<NhaXe> {

	@SuppressWarnings("unchecked")
	@Override
	public List<NhaXe> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(NhaXe.class, "nx");

		return (List<NhaXe>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public NhaXe FindById(int id) {
		return hibernateTemplate.get(NhaXe.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NhaXe> findByCondition(int iddt) {
		DetachedCriteria criteria = DetachedCriteria.forClass(NhaXe.class, "nx");
		criteria.createAlias("nx.cosovatchat", "cosovatchat")
				.add(Restrictions.eq("cosovatchat.diemtruong.madiemtruong", iddt));
		return (List<NhaXe>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public void SaveOrUpdate(NhaXe e) {
		hibernateTemplate.saveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		delete(hibernateTemplate.get(NhaXe.class, id));
	}

}
