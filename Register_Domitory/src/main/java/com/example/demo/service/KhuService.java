package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Khu;


public interface KhuService {
	List<Khu> findAll();
	Khu saveOne(Khu khu);
	Optional<Object> updateOne(Khu khu);
	Optional<Khu> findById(long id);
	Optional<Object> deleteOneById(long id);
}
