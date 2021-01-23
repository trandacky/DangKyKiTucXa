package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Phong;

public interface PhongService {
	List<Phong> findAll();
	Phong saveOne(Phong phong);
	Optional<Object> updateOne(Phong phong);
	Optional<Object> deleteById(long id);
	Optional<Phong> findById(long id);
}
