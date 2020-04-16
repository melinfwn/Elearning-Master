package com.lawencon.elearning.service;

import java.util.List;

import com.lawencon.elearning.model.Pengajar;

public interface PengajarService {
	
	abstract Pengajar findById(String id) throws Exception;
	abstract Pengajar insertPengajar(Pengajar pengajar) throws Exception;
	abstract void deletePengajar(String id) throws Exception;
	abstract Pengajar updatePengajar (String nama, String username, String password, String email) throws Exception;
	abstract List<Pengajar> findAll() throws Exception;
}
