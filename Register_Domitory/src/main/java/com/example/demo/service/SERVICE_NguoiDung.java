package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.NguoiDung;


public interface SERVICE_NguoiDung {
	List<NguoiDung> getAll();
	NguoiDung setData(NguoiDung nguoiDung);
	Optional<Object> update(NguoiDung nguoiDung);
	Optional<NguoiDung> getByID(String id);
	Optional<Object> delete(String id);
}
