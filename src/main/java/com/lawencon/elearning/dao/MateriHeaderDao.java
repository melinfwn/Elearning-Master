package com.lawencon.elearning.dao;

import java.util.List;
import java.util.Map;

import com.lawencon.elearning.model.MateriHeader;

public interface MateriHeaderDao {

	abstract MateriHeader findByTopicCategoryTrainer(String topik, String category, String trainer) throws Exception;

	abstract List<MateriHeader> findAll() throws Exception;

	abstract MateriHeader insertHeader(MateriHeader materiHeader) throws Exception;

	abstract void deleteHeader(String id) throws Exception;

}
