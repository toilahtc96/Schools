package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Khuonvien;
@Repository
public class KhuonvienDaoImpl extends HibernateDaoSupport implements csvcInterface<Khuonvien> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Khuonvien> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Khuonvien.class);
		List<Khuonvien> lis = (List<Khuonvien>) hibernateTemplate.findByCriteria(criteria);
		return lis;
	}

	@SuppressWarnings("unchecked")
	public List<Khuonvien> findByCondition(int diemtruongid) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Khuonvien.class, "kv");
		criteria.createAlias("kv.cosovatchat", "cosovatchat")
				.add(Restrictions.eq("cosovatchat.diemtruong.madiemtruong", diemtruongid));
		List<Khuonvien> lis = (List<Khuonvien>) hibernateTemplate.findByCriteria(criteria);
		return lis;

	}

	@Override
	public Khuonvien FindById(int id) {
		return hibernateTemplate.get(Khuonvien.class, id);
	}

	@Override
	public void SaveOrUpdate(Khuonvien e) {
		hibernateTemplate.saveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		Khuonvien kv = hibernateTemplate.get(Khuonvien.class, id);
		delete(kv);
	}

}
