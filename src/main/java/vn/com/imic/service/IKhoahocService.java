package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Khoahoc;

public interface IKhoahocService {
	List<Khoahoc> getAll();

	void saveOrUpdate(Khoahoc khoahoc);

	void delete(int makhoahoc);

	Khoahoc findByID(int makhoahoc);
}
