package vn.com.imic.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.DaoClass;
import vn.com.imic.dao.GiaovienDao;
import vn.com.imic.dao.LopDao;
import vn.com.imic.dao.NamhocDao;
import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Hocky;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;
import vn.com.imic.model.Namhoc;

@Service
@Transactional(readOnly=false)
public class LopServicesIplm implements LopServices {

	@Autowired
	private LopDao dao;
	
	@Autowired
	private NamhocDao namhocDao;
	
	@Autowired
	private DaoClass<Hocky> hockyDao;
	
	@Autowired
	private GiaovienDao giaovienDao;
	
	@Override
	public List<Khoahoc> getAllLopInKhoahoc(String namhoc, String hocki, String diemtruong) {
		return dao.findAllLopInKhoahoc(namhoc, hocki, diemtruong);
	}

	@Override
	public List<Khoahoc> getLimitLopInKhoahoc(String namhoc, String hocki, String diemtruong, int first, int max) {
		// TODO Auto-generated method stub
		return dao.findLimitLopInKhoahoc(first, max, namhoc, hocki, diemtruong);
	}

	@Override
	public void SaveOrUpdateLopInKhoahoc(Lop lop, Khoahoc khoahoc){
		if(lop != null){
			dao.insertOrUpdate(lop);
			dao.insertOrUpdateLopInKhoahoc(khoahoc);
		}
		else{
			dao.insertOrUpdateLopInKhoahoc(khoahoc);
		}
		
	}

	@Override
	public void DeleteLopInKhoahoc(int makhoahoc) {
		// TODO Auto-generated method stub
		dao.DeleteLopInKhoahoc(makhoahoc);
	}

	@Override
	public int getPage(String namhoc, String hocki, String diemtruong, int max) {
		// TODO Auto-generated method stub
		return dao.Page(namhoc, hocki, diemtruong, max);
	}
	
	public Lop findLop(String tenlop,String diemtruong){
		return dao.findLopByCondition(tenlop,diemtruong);
	}
	
	public Khoahoc getKhoahocById(int id){
		return dao.findByIdLopInKhoahoc(id);
	}
	
	public Lop getLopById(int id){
		return dao.findById(id);
	}

	@Override
	public List<Khoahoc> getLimitLopInKhoahocById(int namhoc, int hocki, int diemtruong, int first, int max) {
		// TODO Auto-generated method stub
		return dao.findLimitLopInKhoahocById(first, max, namhoc, hocki, diemtruong);
	}

	public List<Khoahoc> getAllKhoahoc(){
		return dao.findAllKhoahoc();
	}
	
	public List<Khoahoc> getLopChange(int id){
		return dao.findLopChange(id);
	}
	
	public void changeLop(int id,int hsid,int change){
		dao.changeLopById(id,hsid,change);
	}
	
	public void importLopFromFile(InputStream fis){
//		FileInputStream fis;
//		File file = new File(path);
		try {
//			fis = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fis);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	        int i=0;
	        while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				if(i==0){
					nextRow = iterator.next(); //skip header
					i=1;
				}
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				Khoahoc khoahoc = new Khoahoc();
				Namhoc namhoc = new Namhoc();
				Hocky hocky = new Hocky();
				Giaovien giaovien = new Giaovien();
				Lop l = new Lop();
				String dt = null;
				Cell cell=null;
				int z = 0;
				while (cellIterator.hasNext()) {
					z++;
					cell = cellIterator.next();
					System.out.println("index"+z);
					switch(cell.getColumnIndex()+1){
					case 1:
						break;
					case 2:
						String nh = cell.getStringCellValue();
						System.out.println(nh);
						namhoc = namhocDao.findByTime(nh);
						break;
					case 3:
						String hk = cell.getStringCellValue();
						hocky = hockyDao.findByCondition(hk);
						break;
					case 4:
						dt = cell.getStringCellValue();
						System.out.println(dt);
						break;
					case 5:
						String lop = cell.getStringCellValue();
						l = dao.findLopByCondition(lop, dt);
						break;
					case 6:
						String cn = cell.getStringCellValue();
						System.out.println(cn);
						giaovien = giaovienDao.findByCondition(cn,dt);
						break;
					case 7:
						break;
					case 8:
						break;
					}
					
					
				}
				System.out.println(giaovien+" "+hocky+" "+namhoc+" "+l);
				
				khoahoc.setChunhiem(giaovien);
				khoahoc.setHocky(hocky);
				khoahoc.setLop(l);
				khoahoc.setNamhoc(namhoc);
				dao.insertOrUpdateLopInKhoahoc(khoahoc);
			}
//	        file.delete();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	@Override
	public int getPageById(int namhoc, int hocki, int diemtruong, int max) {
		return dao.PageById(namhoc, hocki, diemtruong, max);
	}
}
