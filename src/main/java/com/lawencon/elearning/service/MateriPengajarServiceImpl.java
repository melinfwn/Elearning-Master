package com.lawencon.elearning.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.dao.MateriPengajarDao;
import com.lawencon.elearning.model.Materi;
import com.lawencon.elearning.model.MateriPengajar;
import com.lawencon.elearning.model.Pengajar;
@Service
@Transactional
public class MateriPengajarServiceImpl implements MateriPengajarService {
	
	@Autowired
	private MateriPengajarDao materiPengajarService;
	
	@Autowired
	private MateriService materiService;
	
	@Autowired
	private PengajarService pengajarService;
	
	@Override
	public MateriPengajar insert(MateriPengajar materiPengajar) throws Exception {
		materiService.insert(materiPengajar.getMateri());
		pengajarService.insertPengajar(materiPengajar.getPengajar());
		return materiPengajarService.insert(materiPengajar);
	}

	@Override
	public MateriPengajar update(String pengajar, String materi) throws Exception {
		MateriPengajar materiPengajar = new MateriPengajar();
		Materi m = new Materi();
		m.setId(materi);
		Pengajar p = new Pengajar();
		p.setPengajarId(pengajar);
		materiPengajar.setMateri(m);
		materiPengajar.setPengajar(p);
		return materiPengajarService.update(materiPengajar);
	}

	@Override
	public void delete(String id) throws Exception {
		materiPengajarService.delete(id);
		
	}

	@Override
	public List<MateriPengajar> findAll() throws Exception {
		return materiPengajarService.findAll();
	}

	@Override
	public MateriPengajar findById(String id) throws Exception {
		return materiPengajarService.findById(id);
	}

	@Override
	public  List<Map<String, Object>> findMateri(String idMateri) throws Exception {
		return materiPengajarService.findMateri(idMateri);
	}

}
