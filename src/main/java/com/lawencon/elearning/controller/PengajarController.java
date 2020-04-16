package com.lawencon.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.elearning.model.Pengajar;
import com.lawencon.elearning.service.PengajarService;

@RestController
@CrossOrigin("*")
public class PengajarController extends BaseController<Pengajar> {

	@Autowired
	private PengajarService pengajarService;

	@GetMapping("/trainer/find")
	public ResponseEntity<?> findPengajarById(@RequestParam("name") String name) {
		Pengajar pengajar = new Pengajar();
		try {
			pengajar = pengajarService.findById(name);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to find trainer", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(pengajar, HttpStatus.OK);
	}

	@PostMapping("/trainer/insert")
	public ResponseEntity<?> insertPengajar(@RequestBody String body) {
		try {
			Pengajar pengajar = readValue(body, Pengajar.class);
			pengajarService.insertPengajar(pengajar);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to insert", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	@PostMapping("/trainer/update")
	public ResponseEntity<?> updatePengajar(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("username") String username, @RequestParam("password") String password) {
		try {
			pengajarService.updatePengajar(name, username, password, email);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	@PostMapping("trainer/delete")
	public ResponseEntity<?> deletePengajar(@RequestParam("id") String id) {
		try {
			pengajarService.deletePengajar(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to delete", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	

}
