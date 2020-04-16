package com.lawencon.elearning.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lawencon.elearning.dao.FileUserDao;
import com.lawencon.elearning.model.FileUser;

@Service
@Transactional
public class FileUserServiceImpl implements FileUserService {

	@Autowired
	private FileUserDao fileUserService;

	@Override
	public FileUser insert(MultipartFile fileUser) throws Exception {
		String fileName = StringUtils.cleanPath(fileUser.getOriginalFilename());
		FileUser fileTask = new FileUser();
		fileTask.setFile(fileUser.getBytes());
		fileTask.setFileName(fileName);
		fileTask.setFileType(fileUser.getContentType());
		return fileUserService.insert(fileTask);
	}

	@Override
	public List<FileUser> findAll() throws Exception {
		return fileUserService.findAll();
	}

	@Override
	public void deleteAll() throws Exception {
		fileUserService.deleteAll();
		
	}

	@Override
	public FileUser findById(String id) throws Exception {
		return fileUserService.findById(id);
	}

}
