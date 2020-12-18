package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Khu;


public interface SERVICE_Khu {
	List<Khu> getAll();
	Khu setData(Khu khu);
	Optional<Object> update(Khu khu);
	Optional<Khu> getByID(long id);
	Optional<Object> delete(long id);
}
