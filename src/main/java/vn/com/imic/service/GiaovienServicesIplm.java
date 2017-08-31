package vn.com.imic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.imic.model.Giaovien;
import  vn.com.imic.dao.GiaovienDao;

import java.util.List;

@Service
@Transactional(readOnly=false)
public class GiaovienServicesIplm implements GiaovienServices {

    @Autowired
    private  GiaovienDao dao;


    @Override
    public Giaovien getGVbyID(int id) {
        return dao.findbyID(id);
    }

    @Override
    public Giaovien findGiaovienbyName(String ten) {
        return dao.findByCondition(ten);
    }

    @Override
    public int getPage(String namhoc, String hocky, String chunhiem, int max) {
        return 0;
        ///Thieu page
    }

    @Override
    public int countGiaoVien() {
         return dao.countGiaoVien();
    }

    @Override
	public void saveOrupdate(Giaovien giaovien) {
        dao.saveOrupdate(giaovien);

    }

    @Override
    public List<Giaovien> getALL(int first, int max) {
      return   dao.getAll( first,  max);
    }

    @Override
	public void deleteGiaovien(int id) {
		 dao.deleteGiaovien(id);
		
	}

}
