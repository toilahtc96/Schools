package vn.com.imic.dao;

import java.util.List;

public interface DaoClass <E>{
	public List<E> findAll();
	public E findObjectById(int id);
	public E findByCondition(String... condition);
	public void Delete(E e);
	public void SaveOrUpdate(E e);
}
