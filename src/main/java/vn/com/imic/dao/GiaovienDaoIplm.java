package vn.com.imic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Giaovien;

@Repository
public class GiaovienDaoIplm extends HibernateDaoSupport implements GiaovienDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Giaovien> getAll(int first, int max) {

        DetachedCriteria criteria = DetachedCriteria.forClass(Giaovien.class);
        List<Giaovien> list = (List<Giaovien>) hibernateTemplate.findByCriteria(criteria);
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Giaovien> findLimit(int first, int max) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Giaovien.class);
        List<Giaovien> list = (List<Giaovien>) hibernateTemplate.findByCriteria(criteria, first, max);

        return list;
    }

    @Override
    public void saveOrupdate(Giaovien giaovien) {
    	hibernateTemplate.saveOrUpdate(giaovien);
    }

    @Override
    public void deleteGiaovien(int id) {
        Giaovien giaovien = findbyID(id);
        System.out.println("Giao Vien: "+giaovien.getTen()+giaovien.getMagiaovien());
        delete(giaovien);
       
    }

    @Override
    public boolean statusGiaovien(boolean status) {
        return true;
    }

    @Override
    public Giaovien findbyID(int id) {

        Giaovien giaovien = hibernateTemplate.get(Giaovien.class, id);
        return giaovien;
    }

    @Override
    public Giaovien findByCondition(String... condition) {
    	DetachedCriteria criteria = DetachedCriteria.forClass(Giaovien.class, "giaovien");
		criteria.createAlias("giaovien.diemtruong", "diemtruong")
		.add(Restrictions.eq("ten",condition[0]))
		.add(Restrictions.eq("diemtruong.tendiemtruong",condition[1]));
			if(hibernateTemplate.findByCriteria(criteria).size()!=0)
				return (Giaovien) hibernateTemplate.findByCriteria(criteria).get(0);
		return null;
    }

    @Override
    public int countGiaoVien() {
        Session session = hibernateTemplate.getSessionFactory().openSession();
        int count = ((Long) session.createQuery("select count(*) from Giaovien").uniqueResult()).intValue();
        return count;
    }
}
