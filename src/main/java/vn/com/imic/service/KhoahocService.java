package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.IKhoahocDAO;
import vn.com.imic.model.Khoahoc;

@Transactional
@Service
public class KhoahocService implements IKhoahocService {
	@Autowired
	private IKhoahocDAO khoahocDAO;

	@Override
	public List<Khoahoc> getAll() {
		return khoahocDAO.getAll();
	}

	@Override
	public void saveOrUpdate(Khoahoc khoahoc) {
		khoahocDAO.saveOrUpdate(khoahoc);
	}

	@Override
	public void delete(int makhoahoc) {
		khoahocDAO.delete(makhoahoc);
	}

	@Override
	public Khoahoc findByID(int makhoahoc) {
		return khoahocDAO.findByID(makhoahoc);
	}

}
