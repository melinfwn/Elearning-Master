package com.lawencon.elearning.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lawencon.elearning.model.FileUser;

public interface FileUserService {

	abstract FileUser insert(MultipartFile fileUser) throws Exception;
	abstract List<FileUser> findAll() throws Exception;
	abstract void deleteAll() throws Exception;
	abstract FileUser findById(String id) throws Exception;
}
