package com.learning.building.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	void save(T entity);
	void remove(T entity);
	List<T> getAll();
	T getById(Integer id);
	
}
