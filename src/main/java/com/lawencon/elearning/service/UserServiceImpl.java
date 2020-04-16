package com.lawencon.elearning.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.elearning.dao.UsersDao;
import com.lawencon.elearning.model.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UsersDao userDao;
	
	@Override
	public String createUser(Users user) throws Exception {
		userDao.createUser(user);
		return "Berhasil Tambah Pengguna";
	}

	@Override
	public List<Map<String, Object>> getUsers() throws Exception {
		return userDao.getUsers();
	}

	@Override
	public String updateUser(Users user) throws Exception {
		userDao.updateUser(user);
		return "Berhasil Update Pengguna";
	}

	@Override
	public String deleteUser(String id) throws Exception {
		userDao.deleteUser(id);
		return "Berhasil Hapus Pengguna";
	}

	@Override
	public List<Map<String, Object>> getById(String id) throws Exception {
		return userDao.getById(id);
	}

}
