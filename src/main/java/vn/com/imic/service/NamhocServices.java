package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Namhoc;

public interface NamhocServices {
	public List<Namhoc> getAllNamhoc();
	public Namhoc getNamhocById(int id);
	public void saveNamhoc(Namhoc nh);
}
