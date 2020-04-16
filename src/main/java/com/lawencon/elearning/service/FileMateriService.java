package com.lawencon.elearning.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.lawencon.elearning.model.FileMateri;

public interface FileMateriService {
	abstract FileMateri insertMateri(MultipartFile file, String topic, String pId, String cId) throws Exception;
	abstract  List<Map<String, Object>> findMateri (String category, String pengajar, String topik) throws Exception;
	abstract List<Map<String, Object>> findByCategory(String category) throws Exception;
	abstract List<Map<String, Object>> findByCategoryAndTrainer(String category, String trainer) throws Exception;
}
