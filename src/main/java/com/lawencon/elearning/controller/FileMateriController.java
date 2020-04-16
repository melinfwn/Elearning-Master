package com.lawencon.elearning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import com.lawencon.elearning.model.FileMateri;
import com.lawencon.elearning.service.FileMateriService;

@RestController
@CrossOrigin("*")
public class FileMateriController extends BaseController<FileMateri> {

	@Autowired
	private FileMateriService materiService;

	@PostMapping("/upload/materi")
	public ResponseEntity<?> uploadMateri(@RequestParam("file") MultipartFile file,@RequestParam("name") String name
			, @RequestParam("topic") String topic, @RequestParam("cId") String cId, @RequestParam("pId") String pId) {
		try {
			materiService.insertMateri(file, topic, pId, cId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/download/")
				.path(StringUtils.cleanPath(file.getOriginalFilename())).path("/db").toUriString();
		return ResponseEntity.ok(fileDownloadUri);
	}

	@GetMapping("/materi/find")
	public ResponseEntity<?> getMateri(@RequestParam("topik") String topik,
			@RequestParam("pengajar") String pengajar, @RequestParam("category") String category) {
		List<Map<String, Object>> listMateri = new ArrayList<>();
		try {
			listMateri = materiService.findMateri(category, pengajar, topik);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(listMateri.get(0).get("type").toString()))
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" + listMateri.get(0).get("judul") + "\"")
				.body(listMateri.get(0).get("file"));
	}
	
//	@GetMapping("/topic")
//	public ResponseEntity<?> getTopic() {
//		List<String> listopic = new ArrayList<>();
//		try {
//			listopic= materiService.find;
//			return new ResponseEntity<>(listopic, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<>(listopic, HttpStatus.BAD_REQUEST);
//	}

}
