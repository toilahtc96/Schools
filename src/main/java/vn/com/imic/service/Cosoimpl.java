package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.csvcInterface;
import vn.com.imic.model.Cosovatchat;

@Service("csservice")
@Transactional(readOnly=false)
public class Cosoimpl implements CosovatchatService<Cosovatchat> {

	@Autowired
	csvcInterface<Cosovatchat> csvcdao;

	@Override
	public List<Cosovatchat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cosovatchat FindById(int id) {
		// TODO Auto-generated method stub
		return csvcdao.FindById(id);
	}

	@Override
	public List<Cosovatchat> findByCondition(int iddt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SaveOrUpdate(Cosovatchat e) {
		csvcdao.SaveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		// TODO Auto-generated method stub

	}

}
