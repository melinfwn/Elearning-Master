package com.lawencon.elearning.dao;

import java.util.List;
import java.util.Map;

import com.lawencon.elearning.model.MateriPengajar;

public interface MateriPengajarDao {

	abstract MateriPengajar insert(MateriPengajar materiPengajar) throws Exception;
	abstract MateriPengajar update(MateriPengajar materiPengajar) throws Exception;
	abstract void delete(String id) throws Exception;
	abstract List<MateriPengajar> findAll() throws Exception;
	abstract MateriPengajar findById(String id) throws Exception;
	abstract  List<Map<String, Object>>findMateri(String idMateri) throws Exception;
	
	
}
