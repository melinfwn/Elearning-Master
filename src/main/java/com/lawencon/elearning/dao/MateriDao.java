package com.lawencon.elearning.dao;

import java.util.List;
import com.lawencon.elearning.model.Materi;
public interface MateriDao {
	
	abstract Materi insertCategory(Materi category) throws Exception;
	abstract Materi updateCategory(Materi category) throws Exception;
	abstract void deleteCategory(String id) throws Exception;
	abstract List<Materi> findAll() throws Exception;

}
