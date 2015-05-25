package com.learning.building.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.learning.building.model.Spent;

@Transactional
@Repository("spentDAO")
public class SpentDAOImpl extends AbstractDao implements SpentDAO{

	@Override
	public void save(Spent entity) {
		save(entity);
	}

	@Override
	public void remove(Spent entity) {
		delete(entity);
	}

	@Override
	public List getAll() {
		Query query = getSession().createQuery("from Spent");
		return query.list();
	}

	@Override
	public Spent getById(Integer id) {
		return getById(id);
	}
	
	public List<Spent> getTotalSpendsWithAverage(){
		Query query = (Query) getSession().createSQLQuery("SELECT MT.name, sum(S.price) as total, count(MT.id) as quantity, avg(S.price) as average FROM spent S INNER JOIN material_type MT ON MT.id = S.material_type_id GROUP BY MT.id");
		return query.list();
	}

}
