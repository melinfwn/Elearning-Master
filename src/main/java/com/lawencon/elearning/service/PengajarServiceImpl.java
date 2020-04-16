package com.lawencon.elearning.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.dao.PengajarDao;
import com.lawencon.elearning.model.Pengajar;
@Service
@Transactional
public class PengajarServiceImpl implements PengajarService {
	
	@Autowired
	private PengajarDao pengajarService;

	@Override
	public Pengajar findById(String id) throws Exception {
		return pengajarService.findById(id);
	}

	@Override
	public Pengajar insertPengajar(Pengajar pengajar) throws Exception {
		return pengajarService.insertPengajar(pengajar);
	}

	@Override
	public void deletePengajar(String id) throws Exception {
		pengajarService.deletePengajar(id);
		
	}

	@Override
	public Pengajar updatePengajar(String nama, String username, String password, String email) throws Exception {
		Pengajar pengajar = new Pengajar();
		pengajar.setEmail(email);
		pengajar.setName(nama);
		pengajar.setPassword(password);
		pengajar.setUsername(username);
		return pengajarService.updatePengajar(pengajar);
	}

	@Override
	public List<Pengajar> findAll() throws Exception {
		return pengajarService.findAll();
	}

	
}
