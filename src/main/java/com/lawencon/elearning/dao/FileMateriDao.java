package com.lawencon.elearning.dao;

import java.util.List;
import java.util.Map;
import com.lawencon.elearning.model.FileMateri;

public interface FileMateriDao {
	
	abstract FileMateri insertMateri(FileMateri materi)throws Exception;
	abstract List<Map<String, Object>> findMateri(String category, String pengajar, String topik) throws Exception;
	abstract List<Map<String, Object>> findByCategory(String category) throws Exception;
	abstract List<Map<String, Object>> findByCategoryAndTrainer(String category, String trainer) throws Exception;
//	List<Materi> findAllActive(String topik) throws Exception;
	abstract List<FileMateri> findAll() throws Exception;
}
