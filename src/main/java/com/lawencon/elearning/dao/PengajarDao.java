package com.lawencon.elearning.dao;

import java.util.List;

import com.lawencon.elearning.model.Pengajar;

public interface PengajarDao {
	abstract Pengajar findById(String id) throws Exception;
	abstract Pengajar insertPengajar(Pengajar pengajar) throws Exception;
	abstract void deletePengajar(String id) throws Exception;
	abstract Pengajar updatePengajar (Pengajar pengajar) throws Exception;
	abstract List<Pengajar> findAll() throws Exception;

}
