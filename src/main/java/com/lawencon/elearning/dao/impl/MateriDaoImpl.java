package com.lawencon.elearning.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.elearning.dao.MateriDao;
import com.lawencon.elearning.model.Materi;

@Repository
public class MateriDaoImpl extends BaseHibernate implements MateriDao {

	@Override
	public Materi insertCategory(Materi category) throws Exception {
		em.persist(category);
		return category;
	}

	@Override
	public Materi updateCategory(Materi category) throws Exception {
		em.merge(category);
		return category;
	}

	@Override
	public void deleteCategory(String id) throws Exception {
		Query q = em.createQuery(" from Materi where id = :id").setParameter("id", id);
		Materi cat = (Materi) q.getSingleResult();
		em.remove(cat);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Materi> findAll() throws Exception {
		Query q = em.createQuery(" from Materi");
		return q.getResultList();
	}

}
