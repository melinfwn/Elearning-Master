package com.lawencon.elearning.service;

import java.util.List;
import java.util.Map;

import com.lawencon.elearning.model.Admin;

public interface AdminService {
	abstract String createAdmin(Admin admin) throws Exception;
	abstract String updateAdmin(Admin admin) throws Exception;
	abstract String deleteAdmin(String id) throws Exception;
	
	abstract List<Map<String, Object>> getById(String id) throws Exception;
	abstract List<Map<String, Object>> getAdmin() throws Exception;
}
