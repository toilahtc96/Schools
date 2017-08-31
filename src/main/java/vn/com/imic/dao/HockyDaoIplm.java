package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Hocky;

@Repository("hockyDao")
public class HockyDaoIplm extends HibernateDaoSupport implements DaoClass<Hocky>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Hocky> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Hocky.class);
		return (List<Hocky>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Hocky findObjectById(int id) {
		return hibernateTemplate.get(Hocky.class, id);
	}

	@Override
	public Hocky findByCondition(String... condition){
		DetachedCriteria criteria = DetachedCriteria.forClass(Hocky.class,"hocky");
		for (String co : condition) {
			criteria.add(Restrictions.or(Restrictions.eq("tenhocky", co)));
		}
		
		return (Hocky) hibernateTemplate.findByCriteria(criteria).get(0);
	}

	@Override
	public void Delete(Hocky e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SaveOrUpdate(Hocky e) {
		// TODO Auto-generated method stub
		
	}
}
