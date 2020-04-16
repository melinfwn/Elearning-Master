package com.lawencon.elearning.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.MateriHeaderDao;
import com.lawencon.elearning.model.MateriHeader;
@Repository
public class MateriHeaderDaoImpl extends BaseHibernate implements MateriHeaderDao {

	@SuppressWarnings("unchecked")
	@Override
	public MateriHeader findByTopicCategoryTrainer(String topik, String category, String trainer)
			throws Exception {
		System.out.println(topik);
		Query q = em.createQuery("from MateriHeader mh where topic =: tParam and mh.pengajar.pengajarId =: pParam and mh.materi.id =: cParam ")
				.setParameter("tParam", topik)
				.setParameter("pParam", trainer)
				.setParameter("cParam", category);
		return (MateriHeader) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MateriHeader> findAll() throws Exception {
		Query q = em.createQuery(" from MateriHeader");
		return q.getResultList();
	}

	@Override
	public MateriHeader insertHeader(MateriHeader materiHeader) throws Exception {
		em.persist(materiHeader);
		return materiHeader;
	}

	@Override
	public void deleteHeader(String id) throws Exception {
		Query q = em.createQuery(" from MateriHeader where id = :id").setParameter("id", id);
		MateriHeader h = (MateriHeader) q.getSingleResult();
		em.remove(h);
		
	}

}
