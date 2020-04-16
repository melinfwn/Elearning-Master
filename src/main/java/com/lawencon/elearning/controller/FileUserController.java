package com.lawencon.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lawencon.elearning.model.FileUser;
import com.lawencon.elearning.service.FileUserService;

@RestController
@CrossOrigin("*")
public class FileUserController extends BaseController<FileUser> {

	@Autowired
	private FileUserService fileUserService;

	@PostMapping("/upload/task")
	public ResponseEntity<?> uploadTask(@RequestParam("file") MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/download/")
				.path(fileName).path("/db").toUriString();
		return ResponseEntity.ok(fileDownloadUri);
	}
	
	@GetMapping("download/task")
	public ResponseEntity<?> downloadTask(@RequestParam("id") String id) {
		FileUser fileUser = new FileUser();
		try {
			fileUser = fileUserService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileUser.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileUser.getFileName() + "\"")
				.body(fileUser.getFile());
		
	}

}
