package com.lawencon.elearning.dao;

import java.util.List;

import com.lawencon.elearning.model.FileUser;

public interface FileUserDao {
	
	abstract FileUser insert(FileUser fileUser) throws Exception;
	abstract List<FileUser> findAll() throws Exception;
	abstract void deleteAll() throws Exception;
	abstract FileUser findById(String id) throws Exception;
}
