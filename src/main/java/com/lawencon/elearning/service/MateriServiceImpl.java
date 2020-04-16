package com.lawencon.elearning.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.dao.MateriDao;
import com.lawencon.elearning.model.Materi;
@Service
@Transactional
public class MateriServiceImpl implements MateriService {
	
	@Autowired
	private MateriDao categoriesService;

	@Override
	public Materi insert(Materi category) throws Exception {
		return categoriesService.insertCategory(category);
	}

	@Override
	public Materi updateMateri(String nama) throws Exception {
		Materi materi = new Materi();
		materi.setName(nama);
		return categoriesService.updateCategory(materi);
	}

	@Override
	public void deleteMateri(String id) throws Exception {
		categoriesService.deleteCategory(id);
		
	}

	@Override
	public List<Materi> findAll() throws Exception {
		return categoriesService.findAll();
	}

}
