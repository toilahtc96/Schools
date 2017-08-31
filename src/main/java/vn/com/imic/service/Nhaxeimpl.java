package vn.com.imic.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.csvcInterface;
import vn.com.imic.model.NhaXe;
@Service("nhaxeS")
@Transactional
public class Nhaxeimpl  implements CosovatchatService<NhaXe> {

	@Autowired
	private csvcInterface<NhaXe> nxdao;
	@Override
	public List<NhaXe> findAll() {
		// TODO Auto-generated method stub
		return nxdao.findAll();
	}

	@Override
	public NhaXe FindById(int id) {
		// TODO Auto-generated method stub
		return nxdao.FindById(id);
	}

	@Override
	public List<NhaXe> findByCondition(int iddt) {
		// TODO Auto-generated method stub
		return nxdao.findByCondition(iddt);
	}
	@Override
	public void SaveOrUpdate(NhaXe e) {
		nxdao.SaveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		nxdao.deleteByid(id);
	}

}
