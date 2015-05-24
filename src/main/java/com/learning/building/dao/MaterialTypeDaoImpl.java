package com.learning.building.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.learning.building.model.MaterialType;

@Transactional
@Repository("materialTypeDao")
public class MaterialTypeDaoImpl extends AbstractDao implements GenericDAO<MaterialType> {

	public MaterialTypeDaoImpl() {
		System.out.println("MaterialTypeDaoImpl criado");
	}
	
	@Override
	public void save(MaterialType entity) {
		persist(entity);
	}

	@Override
	public void remove(MaterialType entity) {
		delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaterialType> getAll() {
		return (List<MaterialType>) getSession().createCriteria(MaterialType.class).list();
	}

	@Override
	public MaterialType getById(Integer id) {
		Criteria criteria = getSession().createCriteria(MaterialType.class);
		criteria.add(Restrictions.eq("id", id));
		return (MaterialType) criteria.uniqueResult();
	}

}
