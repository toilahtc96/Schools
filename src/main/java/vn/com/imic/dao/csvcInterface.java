package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.NhaXe;

public interface csvcInterface<E> {

	public List<E> findAll();
	public E FindById(int id);
	public List<E> findByCondition(int iddt);
	public void SaveOrUpdate(E e);
	public void deleteByid(int id);
}
