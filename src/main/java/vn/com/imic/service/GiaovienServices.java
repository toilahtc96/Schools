package vn.com.imic.service;


import vn.com.imic.model.Giaovien;
import java.util.List;

public interface GiaovienServices {

  
    Giaovien  getGVbyID(int id);

    Giaovien findGiaovienbyName(String ten);
    void saveOrupdate(Giaovien giaovien);
    List<Giaovien> getALL(int first, int max);
    void deleteGiaovien(int id);

    int getPage(String namhoc, String hocky, String chunhiem, int max);
    int countGiaoVien();


}
