package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Hocsinh;
import vn.com.imic.model.Khoahoc;

@Repository("HocSinhDao")
public class HocsinhDaoIplm extends HibernateDaoSupport implements DaoClass<Hocsinh>,HocsinhDao{

	@Override
	public List<Hocsinh> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hocsinh findObjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hocsinh> findAllInKhoahoc(int makhoahoc) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hocsinh> findLimitInKhoahoc(int makhoahoc, int first, int max) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Hocsinh.class,"hocsinh");
		criteria.createAlias("hocsinh.khoahoc","khoahoc")
		.add(Restrictions.eq("khoahoc.makhoahoc",makhoahoc));
		List<Hocsinh> lis = (List<Hocsinh>) hibernateTemplate.findByCriteria(criteria, first, max);
		System.out.println("hoc sinh "+lis.size());
		return lis;
	}

	@Override
	public int CountHocsinhInKhoahoc(int khoahoc,int max) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Hocsinh.class,"hocsinh");
		criteria.createAlias("hocsinh.khoahoc","khoahoc")
		.add(Restrictions.eq("khoahoc.makhoahoc",khoahoc))
		.setProjection(Projections.rowCount());
		@SuppressWarnings("rawtypes")
		List lis = hibernateTemplate.findByCriteria(criteria);
		Long x = (Long) lis.get(0);
		int c = x.intValue();
		if(c%max!=0)
			return 1+(c/max);
		return c/max;
	}
	
	@Override
	public int CountHocsinhInKhoahoc(int khoahoc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Hocsinh.class,"hocsinh");
		criteria.createAlias("hocsinh.khoahoc","khoahoc")
		.add(Restrictions.eq("khoahoc.makhoahoc",khoahoc))
		.setProjection(Projections.rowCount());
		@SuppressWarnings("rawtypes")
		List lis = hibernateTemplate.findByCriteria(criteria);
		Long x = (Long) lis.get(0);
		return x.intValue();
		}
	
	public void deleteHocsinhInKhoahoc(int lop, int hocsinh){

		Khoahoc kh = hibernateTemplate.get(Khoahoc.class, lop);
		Hocsinh hs = hibernateTemplate.get(Hocsinh.class, hocsinh);
		
		for(int i=0;i<kh.getHocsinh().size();i++)
			if(kh.getHocsinh().get(i).getMaso() == hocsinh)
				kh.getHocsinh().remove(i);
		
		for(int i=0;i<hs.getKhoahoc().size();i++)
			if(hs.getKhoahoc().get(i).getMakhoahoc() == lop)
				hs.getKhoahoc().remove(i);
		
		save(kh);
		save(hs);
		
	}

	@SuppressWarnings("unchecked")
	public Hocsinh findHocsinh(String ten,String diachi){
		DetachedCriteria criteria = DetachedCriteria.forClass(Hocsinh.class,"hocsinh");
		criteria.add(Restrictions.eq("hocsinh.ten",ten))
		.add(Restrictions.eq("hocsinh.diachi",diachi));
		
		List<Hocsinh> lis = (List<Hocsinh>) hibernateTemplate.findByCriteria(criteria);
		if(lis.size()==0)
			return null;
		return lis.get(0);
	}
	
	public void SaveOrUpdateHocsinhInLop(int kh,Hocsinh hs){
		
		Khoahoc khoahoc = hibernateTemplate.get(Khoahoc.class, kh);
		save(hs);
		khoahoc.getHocsinh().add(hs);
		save(khoahoc);
	}
	
	@SuppressWarnings("unchecked")
	public List<Hocsinh> findAllHocsinh(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Hocsinh.class);
		return (List<Hocsinh>) hibernateTemplate.findByCriteria(criteria);
	}
	
	public Hocsinh findByCondition(String... condition){
		return null;
	}

	@Override
	public void Delete(Hocsinh e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SaveOrUpdate(Hocsinh e) {
		// TODO Auto-generated method stub
		
	}
}
