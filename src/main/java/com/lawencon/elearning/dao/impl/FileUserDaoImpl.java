package com.lawencon.elearning.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.FileUserDao;
import com.lawencon.elearning.model.FileUser;
@Repository
public class FileUserDaoImpl extends BaseHibernate implements FileUserDao{

	@Override
	public FileUser insert(FileUser fileUser) throws Exception {
		em.persist(fileUser);
		return fileUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FileUser> findAll() throws Exception {
		Query q = em.createQuery(" from FileUser");
		return q.getResultList();
	}

	@Override
	public void deleteAll() throws Exception {
		Query q = em.createQuery(" from FileUser");
		FileUser file = (FileUser) q.getResultList();
		em.remove(file);
		
	}

	@Override
	public FileUser findById(String id) throws Exception {
		Query q = em.createQuery(" from FileUser where id = :id").setParameter("id", id);
		FileUser file = (FileUser) q.getSingleResult();
		return file;
	}

}
