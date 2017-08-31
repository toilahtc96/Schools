package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.csvcInterface;
import vn.com.imic.model.Nhavesinh;
import vn.com.imic.model.Phonghoc;

@Service("phonghocS")
@Transactional
public class Phonghocimpl implements CosovatchatService<Phonghoc> {
	@Autowired
	csvcInterface<Phonghoc> phdao;

	@Override
	public List<Phonghoc> findAll() {
		// TODO Auto-generated method stub
		return phdao.findAll();
	}

	@Override
	public Phonghoc FindById(int id) {
		// TODO Auto-generated method stub
		return phdao.FindById(id);
	}

	@Override
	public List<Phonghoc> findByCondition(int iddt) {
		// TODO Auto-generated method stub
		return phdao.findByCondition(iddt);
	}

	@Override
	public void SaveOrUpdate(Phonghoc e) {
		phdao.SaveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		phdao.deleteByid(id);
	}

}
