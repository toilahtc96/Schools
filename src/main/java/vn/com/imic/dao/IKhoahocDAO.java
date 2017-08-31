package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Khoahoc;

public interface IKhoahocDAO {
	List<Khoahoc> getAll();

	void saveOrUpdate(Khoahoc khoahoc);

	void delete(int makhoahoc);

	Khoahoc findByID(int makhoahoc);
}
