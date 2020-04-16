package com.lawencon.elearning.service;

import java.util.List;

import com.lawencon.elearning.model.Materi;

public interface MateriService {

	public Materi insert(Materi category) throws Exception;
	abstract Materi updateMateri(String nama) throws Exception;
	abstract void deleteMateri(String id) throws Exception;
	abstract List<Materi> findAll() throws Exception;

}
