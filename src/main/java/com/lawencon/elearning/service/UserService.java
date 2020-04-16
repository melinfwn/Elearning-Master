package com.lawencon.elearning.service;

import java.util.List;
import java.util.Map;

import com.lawencon.elearning.model.Users;

public interface UserService {
	abstract String createUser(Users user) throws Exception;
	abstract String updateUser(Users user) throws Exception;
	abstract String deleteUser(String id) throws Exception;
	
	abstract List<Map<String, Object>> getById(String id) throws Exception;
	abstract List<Map<String, Object>> getUsers() throws Exception;

}
