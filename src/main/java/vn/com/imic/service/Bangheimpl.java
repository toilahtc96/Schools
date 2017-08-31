package vn.com.imic.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.csvcInterface;
import vn.com.imic.model.Banghe;
@Service("bangheS")
@Transactional
public class Bangheimpl implements CosovatchatService<Banghe> {
	
	@Autowired
	csvcInterface<Banghe> bgdao;

	@Override
	public List<Banghe> findAll() {
		return bgdao.findAll();
	}

	@Override
	public Banghe FindById(int id) {
		return bgdao.FindById(id);
	}

	@Override
	public List<Banghe> findByCondition(int iddt) {
		return bgdao.findByCondition(iddt);
	}

	@Override
	public void SaveOrUpdate(Banghe e) {
	bgdao.SaveOrUpdate(e);
		
	}

	@Override
	public void deleteByid(int id) {
		bgdao.deleteByid(id);
	}
	
	
}
