package vn.com.imic.dao;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Hocsinh;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;

@Repository
public class LopDaoIplm extends HibernateDaoSupport implements LopDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Lop> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Lop.class);
		List<Lop> lis = (List<Lop>) hibernateTemplate.findByCriteria(criteria);
		System.out.println(lis.get(0).getMalop());
		return lis;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lop> findLimit(int first, int max) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Lop.class);
		List<Lop> lis = (List<Lop>) hibernateTemplate.findByCriteria(criteria, first,max);
		return lis;
	}

	@Override
	public Lop findById(int id) {
		Lop lop = hibernateTemplate.get(Lop.class, id);
		return lop;
	}

	@Override
	public void insertOrUpdate(Lop lop) {
		save(lop);
	}

	@Override
	public void DeleteLop(int id) {
		delete(hibernateTemplate.get(Lop.class, id));
	}

	public int CountLop(){
		Session session = hibernateTemplate.getSessionFactory().openSession();
		int count = ((Long)session.createQuery("select count(*) from Lop").uniqueResult()).intValue();//from Lop.class.getName()
		return count;
	}
	
	
	public Lop findLopByCondition(String tenlop,String diemtruong){
		DetachedCriteria criteria = DetachedCriteria.forClass(Lop.class, "lop");
		criteria.createAlias("lop.diemtruong", "diemtruong")
		.add(Restrictions.eq("tenlop",tenlop))
		.add(Restrictions.eq("diemtruong.tendiemtruong",diemtruong));
			if(hibernateTemplate.findByCriteria(criteria).size()!=0)
				return (Lop) hibernateTemplate.findByCriteria(criteria).get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Khoahoc> findAllLopInKhoahoc(String namhoc,String hocki,String diemtruong) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Khoahoc.class, "khoahoc");
		criteria.createAlias("khoahoc.lop.diemtruong", "diemtruong")
		.createAlias("khoahoc.namhoc","namhoc")
		.createAlias("khoahoc.hocky","hocky")
		.add(Restrictions.eq("namhoc.thoigian",namhoc))
		.add(Restrictions.eq("hocky.tenhocky", hocki))
		.add(Restrictions.eq("diemtruong.tendiemtruong", diemtruong));
		 List<Khoahoc> lis = (List<Khoahoc>) hibernateTemplate.findByCriteria(criteria);
		System.out.println(lis.size());
		return lis;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Khoahoc> findLimitLopInKhoahoc(int first, int max,String namhoc,String hocki,String diemtruong) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Khoahoc.class, "khoahoc");
		criteria.createAlias("khoahoc.lop.diemtruong", "diemtruong")
		.createAlias("khoahoc.namhoc","namhoc")
		.createAlias("khoahoc.hocky","hocky")
		.add(Restrictions.eq("namhoc.thoigian",namhoc))
		.add(Restrictions.eq("hocky.tenhocky", hocki))
		.add(Restrictions.eq("diemtruong.tendiemtruong", diemtruong));
		 List<Khoahoc> lis = (List<Khoahoc>) hibernateTemplate.findByCriteria(criteria,first,max);
		System.out.println(lis.size());
		return lis;
	}
	
	@Override
	public Khoahoc findByIdLopInKhoahoc(int id) {
		return hibernateTemplate.get(Khoahoc.class, id);
	}

	@Override
	public void insertOrUpdateLopInKhoahoc(Khoahoc khoahoc){
			save(khoahoc);
	}

	@Override
	public void DeleteLopInKhoahoc(int id) {
		// TODO Auto-generated method stub
		Khoahoc kh = hibernateTemplate.get(Khoahoc.class, id);
		delete(kh);
	}

	@Override
	public int CountLopInKhoahoc(String namhoc,String hocki,String diemtruong) {
//		DetachedCriteria criteria = DetachedCriteria.forClass(Khoahoc.class, "khoahoc");
//		criteria.createAlias("khoahoc.lop.diemtruong", "diemtruong")
//		.createAlias("khoahoc.namhoc","namhoc")
//		.createAlias("khoahoc.hocky","hocky")
//		.setProjection(Projections.rowCount())
//		.add(Restrictions.eq("namhoc.thoigian",namhoc))
//		.add(Restrictions.eq("hocky.tenhocky", hocki))
//		.add(Restrictions.eq("diemtruong.tendiemtruong", diemtruong));
//		List count = hibernateTemplate.findByCriteria(criteria);
		Session session = hibernateTemplate.getSessionFactory().openSession();
		int count = ((Long)session.createQuery("select count(*) from Khoahoc a,Lop b,Diemtruong c,Namhoc d,Hocky e where a.lop=b.malop and b.diemtruong=c.madiemtruong and a.namhoc=d.manamhoc and a.hocky=e.mahocky and c.tendiemtruong='"+diemtruong+"' and d.thoigian='"+namhoc+"' and e.tenhocky='"+hocki+"'")
				.uniqueResult()).intValue(); //from ??? luôn phải trùng tên với các model trong java , không phải sql
		System.out.println(count+" so lop");
		return count;
	}
	
	public int Page(String namhoc,String hocki,String diemtruong,int max){
		int count = CountLopInKhoahoc(namhoc, hocki, diemtruong);
		System.out.println(count/max+" page");
		if(count%max!=0)
			return 1+(count/max);
		return count/max;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Khoahoc> findLimitLopInKhoahocById(int first, int max,int namhoc,int hocky,int diemtruong) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Khoahoc.class, "khoahoc");
		criteria.createAlias("khoahoc.lop.diemtruong", "diemtruong")
		.createAlias("khoahoc.namhoc","namhoc")
		.createAlias("khoahoc.hocky","hocky")
		.add(Restrictions.eq("namhoc.manamhoc",namhoc))
		.add(Restrictions.eq("hocky.mahocky", hocky))
		.add(Restrictions.eq("diemtruong.madiemtruong", diemtruong));
		 List<Khoahoc> lis = (List<Khoahoc>) hibernateTemplate.findByCriteria(criteria,first,max);
		System.out.println(lis.size());
		return lis;
	}

	@Override
	public int CountLopInKhoahocById(int namhoc, int hocki, int diemtruong) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		int count = ((Long)session.createQuery("select count(*) from Khoahoc a,Lop b,Diemtruong c,Namhoc d,Hocky e where a.lop=b.malop and b.diemtruong=c.madiemtruong and a.namhoc=d.manamhoc and a.hocky=e.mahocky and c.madiemtruong='"+diemtruong+"' and d.manamhoc='"+namhoc+"' and e.mahocky='"+hocki+"'")
				.uniqueResult()).intValue(); //from ??? luôn phải trùng tên với các model trong java , không phải sql
		System.out.println(count+" so lop");
		return count;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Khoahoc> findAllKhoahoc(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Khoahoc.class);
		
		return (List<Khoahoc>) hibernateTemplate.findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<Khoahoc> findLopChange(int id){
		Khoahoc kh = hibernateTemplate.get(Khoahoc.class, id);
		System.out.println(kh.getHocky()+""+kh.getNamhoc()+""+kh.getLop().getDiemtruong());
		DetachedCriteria criteria = DetachedCriteria.forClass(Khoahoc.class, "khoahoc");
		criteria.createAlias("khoahoc.lop.diemtruong", "diemtruong")
		.createAlias("khoahoc.namhoc","namhoc")
		.createAlias("khoahoc.hocky","hocky")
		.add(Restrictions.eq("namhoc.manamhoc",kh.getNamhoc().getManamhoc()))
		.add(Restrictions.eq("hocky.mahocky", kh.getHocky().getMahocky()))
		.add(Restrictions.eq("diemtruong.madiemtruong", kh.getLop().getDiemtruong().getMadiemtruong()));
		List<Khoahoc> lis = (List<Khoahoc>) hibernateTemplate.findByCriteria(criteria);
		return lis;
	}
	
	public void changeLopById(int id,int hsid,int change){
		Hocsinh hs = hibernateTemplate.get(Hocsinh.class,hsid);
		for(int i=0;i<hs.getKhoahoc().size();i++)
			if(hs.getKhoahoc().get(i).getMakhoahoc() == id){
				hs.getKhoahoc().remove(i);
				hs.getKhoahoc().add(hibernateTemplate.get(Khoahoc.class,change));
				break;
			}
		Khoahoc kh = hibernateTemplate.get(Khoahoc.class,id);
		for(int i=0;i<kh.getHocsinh().size();i++)
			if(kh.getHocsinh().get(i).getMaso() == hsid){
				kh.getHocsinh().remove(i);
				break;
			}
		Khoahoc khc = hibernateTemplate.get(Khoahoc.class,change);
		khc.getHocsinh().add(hs);
		save(hs);
		save(kh);
		save(khc);
	}
	
	public boolean addHocsinhInLop(int hsid,int id){
		Hocsinh hs = hibernateTemplate.get(Hocsinh.class, hsid);
		Khoahoc kh = hibernateTemplate.get(Khoahoc.class,id);
		for(int i=0;i<kh.getHocsinh().size();i++){
			if(kh.getHocsinh().get(i).getMaso() == hsid){
				return false;
			}
		}
		
		hs.getKhoahoc().add(kh);
		kh.getHocsinh().add(hs);
		save(hs);
		save(kh);
		return true;
	}

	@Override
	public int PageById(int namhoc, int hocki, int diemtruong, int max) {
		int count = CountLopInKhoahocById(namhoc, hocki, diemtruong);
		System.out.println(count/max+" page");
		if(count%max!=0)
			return 1+(count/max);
		return count/max;
	}
	
	@SuppressWarnings("deprecation")
	public ByteArrayOutputStream download(){
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		SessionFactoryImplementor iplm =  (SessionFactoryImplementor)getSession();
		ConnectionProvider cp = iplm.getConnectionProvider();
		Connection con = null;
		try {
			con = cp.getConnection();
			CallableStatement call = null;
		
			call = con.prepareCall("{call danhsach()}");
			ResultSet result = call.executeQuery();
		 
		
		
		//List<Khoahoc> lis = (List<Khoahoc>) hibernateTemplate.findByCriteria(criteria);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("excel");
		
		String header[] = {"STT","Năm học","Học kỳ","Điểm trường","Lớp","Chủ nhiệm","Sỹ số","Số tiết hoc / Tuần"};
		
		
		
		Map<String, Object[]> map = new TreeMap<String, Object[]>();
		map.put("1",header);
		int i=0;
		while(result.next()){
			System.out.println(result.getString(1));
			map.put((i+2)+"",new Object[] {(i+1),result.getString(3),
					result.getString(4),result.getString(2),
					result.getString(1),result.getString(5),
					result.getInt(6),result.getInt(7)});
			i++;
		}
		
		int rowCount = 0;
		int cellCount = 0;
		Set<String> keymap = map.keySet();
		for(String key : keymap){
			Row row = sheet.createRow(rowCount++);
			Object[] obj = map.get(key);
			System.out.println(key);
			cellCount=0;
			for(Object o : obj){
				Cell cell = row.createCell(cellCount++);
				if(o instanceof String)
					cell.setCellValue((String)o);
				else
					cell.setCellValue((Integer)o);
			}
		}
		
			workbook.write(outputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return outputStream;
	}
	
	public void importFile(String path){
		
	}
}
