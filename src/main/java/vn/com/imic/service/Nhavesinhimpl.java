package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.csvcInterface;
import vn.com.imic.model.Nhavesinh;
@Service("nhavesinhS")
@Transactional
public class Nhavesinhimpl implements CosovatchatService<Nhavesinh>{

	@Autowired
	csvcInterface<Nhavesinh> nvsdao;

	@Override
	public List<Nhavesinh> findAll() {
		return nvsdao.findAll();
	}

	@Override
	public Nhavesinh FindById(int id) {
		// TODO Auto-generated method stub
		return nvsdao.FindById(id);
	}

	@Override
	public List<Nhavesinh> findByCondition(int iddt) {
		// TODO Auto-generated method stub
		return nvsdao.findByCondition(iddt);
	}

	@Override
	public void SaveOrUpdate(Nhavesinh e) {
		nvsdao.SaveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		nvsdao.deleteByid(id);
	}
	

}
