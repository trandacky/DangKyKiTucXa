package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.NguoiDung;


public interface NguoiDungService {
	List<NguoiDung> findAll();
	NguoiDung saveOne(NguoiDung nguoiDung);
	Optional<Object> updateOne(NguoiDung nguoiDung);
	List<NguoiDung> findById(String id);
	Optional<Object> deleteById(String id);
	List<NguoiDung> seach(String seachString);
	
}
