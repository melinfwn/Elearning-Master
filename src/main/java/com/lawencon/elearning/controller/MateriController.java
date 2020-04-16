package com.lawencon.elearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.elearning.model.Materi;
import com.lawencon.elearning.service.MateriService;

@RestController
@CrossOrigin("*")
public class MateriController extends BaseController<Materi> {
	
	@Autowired
	private MateriService materiService;
	
	@PostMapping("/materi/insert")
	public ResponseEntity<?> insertMateri(@RequestBody String body){
		try {
			Materi category = readValue(body, Materi.class);
			materiService.insert(category);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to insert", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping("/materi/update")
	public ResponseEntity<?> updateMateri(@RequestBody String nama){
		try {
			materiService.updateMateri(nama);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping("/materi/delete")
	public ResponseEntity<?> deleteMateri(@RequestBody String id){
		try {
			materiService.deleteMateri(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to delete", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@GetMapping("/materi/show")
	public ResponseEntity<?> showAllMateri(){
		List<Materi> list = new ArrayList<>();
		try {
			list = materiService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to show", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	


}
