package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Giaovien;

public interface GiaovienDao {
    List<Giaovien> getAll(int first, int max);

    List<Giaovien> findLimit(int first, int max);

    void saveOrupdate(Giaovien giaovien);

    void deleteGiaovien(int id);

    boolean statusGiaovien(boolean status);
    //public void dfPass();
    Giaovien findbyID(int id);


    public int countGiaoVien();
    Giaovien findByCondition(String... condition);
    //public Giaovien Page();

}
