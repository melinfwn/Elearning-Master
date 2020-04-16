package com.lawencon.elearning.dao;

import java.util.List;
import java.util.Map;

import com.lawencon.elearning.model.Admin;

public interface AdminDao {
	abstract void createAdmin(Admin admin) throws Exception;
	abstract void updateAdmin(Admin admin) throws Exception;
	abstract void deleteAdmin(String id) throws Exception;
	
	abstract List<Map<String, Object>> getById(String id) throws Exception;
	abstract List<Map<String, Object>> getAdmin() throws Exception;
}
