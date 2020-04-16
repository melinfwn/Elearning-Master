package com.lawencon.elearning.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.elearning.dao.UsersDao;
import com.lawencon.elearning.model.Users;

@Repository
public class UsersDaoImpl extends BaseHibernate implements UsersDao {

	@Override
	public void createUser(Users user) throws Exception {
		em.persist(user);
	}


	@Override
	public void updateUser(Users user) throws Exception {
		em.merge(user);
	}

	@Override
	public void deleteUser(String id) throws Exception {
		Query q = em.createQuery(" from Users where userId = :idParam");
		q.setParameter("idParam", id);
		Users temp = new Users();
		temp = (Users) q.getSingleResult();
		em.remove(temp);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getById(String id) throws Exception {
		Query a = em.createNativeQuery("select nama, email, username from tb_user where userid = :idParam");
		a.setParameter("idParam", id);
		List<Object[]> result = a.getResultList();
		return bMapperHibernate(result, "nama", "email", "username");
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getUsers() throws Exception {
		Query a = em.createNativeQuery("select nama, email, username from tb_user");
		List<Object[]> result = a.getResultList();
		return bMapperHibernate(result, "nama", "email", "username");
	}

}
