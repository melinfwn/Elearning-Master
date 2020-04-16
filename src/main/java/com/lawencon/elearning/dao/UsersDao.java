package com.lawencon.elearning.dao;

import java.util.List;
import java.util.Map;

import com.lawencon.elearning.model.Users;

public interface UsersDao {
	abstract void createUser(Users user) throws Exception;
	abstract void updateUser(Users user) throws Exception;
	abstract void deleteUser(String id) throws Exception;
	
	abstract List<Map<String, Object>> getById(String id) throws Exception;
	abstract List<Map<String, Object>> getUsers() throws Exception;

}
