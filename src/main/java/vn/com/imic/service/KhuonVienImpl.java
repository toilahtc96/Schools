package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.csvcInterface;
import vn.com.imic.model.Khuonvien;

@Transactional
@Service("khuonvienS")
public class KhuonVienImpl implements CosovatchatService<Khuonvien> {

	@Autowired
	csvcInterface<Khuonvien> kvdao;

	@Override
	public List<Khuonvien> findAll() {
		// TODO Auto-generated method stub
		return kvdao.findAll();
	}

	@Override
	public Khuonvien FindById(int id) {
		// TODO Auto-generated method stub
		return kvdao.FindById(id);
	}

	@Override
	public List<Khuonvien> findByCondition(int iddt) {
		// TODO Auto-generated method stub
		return kvdao.findByCondition(iddt);
	}

	@Override
	public void SaveOrUpdate(Khuonvien e) {
		kvdao.SaveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		kvdao.deleteByid(id);
	}
}
