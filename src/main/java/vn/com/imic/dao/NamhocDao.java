package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Namhoc;

public interface NamhocDao {
	public List<Namhoc> findAllNamhoc();
	public Namhoc findNamhocById(int manamhoc);
	public Namhoc findByTime(String time);
	public void SaveOrUpdateNamhoc(Namhoc nh);
}
