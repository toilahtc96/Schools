package vn.com.imic.service;

import java.util.List;

public interface ServicesInterface <E>{
	public List<E> getAllObjects();
	public E getObjectById(int id);
	public void deleteObject(E e);
	public void saveOrUpdateObject(E e);
}
