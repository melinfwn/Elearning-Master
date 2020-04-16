package com.lawencon.elearning.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.PengajarDao;
import com.lawencon.elearning.model.Pengajar;
@Repository
public class PengajarDaoImpl extends BaseHibernate implements PengajarDao{
	
	@Override
	public Pengajar findById(String id) throws Exception {
		Query q = em.createQuery("select name, username, email from Pengajar where id = :id").setParameter("id", id);
		Pengajar pengajar = (Pengajar) q.getSingleResult();
		return pengajar;
	}

	@Override
	public Pengajar insertPengajar(Pengajar pengajar) throws Exception {
		em.persist(pengajar);
		return pengajar;
	}

	@Override
	public void deletePengajar(String id) throws Exception {
		Query q = em.createQuery(" from Pengajar where id = :id").setParameter("id", id);
		Pengajar pengajar = (Pengajar) q.getSingleResult();
		em.remove(pengajar);
		
	}

	@Override
	public Pengajar updatePengajar(Pengajar pengajar) throws Exception {
		return em.merge(pengajar);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pengajar> findAll() throws Exception {
		Query q = em.createQuery(" from Pengajar");
		return q.getResultList();
	}
	
	

}
