package com.lawencon.elearning.service;

import java.util.List;
import java.util.Map;

import com.lawencon.elearning.model.MateriPengajar;

public interface MateriPengajarService {
	abstract MateriPengajar insert(MateriPengajar materiPengajar) throws Exception;
	abstract MateriPengajar update(String pengajar, String materi) throws Exception;
	abstract void delete(String id) throws Exception;
	abstract List<MateriPengajar> findAll() throws Exception;
	abstract MateriPengajar findById(String id) throws Exception;
	abstract List<Map<String, Object>> findMateri(String idMateri) throws Exception;
}
