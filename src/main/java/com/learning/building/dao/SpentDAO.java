package com.learning.building.dao;

import java.util.List;

import com.learning.building.model.Spent;

public interface SpentDAO  {
	void save(Spent entity);
	void remove(Spent entity);
	List<Spent> getAll();
	Spent getById(Integer id);
	List<Spent> getTotalSpendsWithAverage();
}
